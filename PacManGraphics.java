
/**
 * Write a description of class PacManGraphics here.
 *
 * @author (Zack Chaffey)
 * @version (10/27/20)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PacManGraphics extends JPanel
{
    Image eatghost;
    Image pacman;
    Image cherry;
    Image ghost1;
    Image ghost2;
    Image ghost3;
    Image ghost4;
    Image[] ghostimages;
    int index,eeatghostcounter,llevel;
    boolean endgamme,ddrawfruit,sstartgame;
    ArrayList<Pellets1> ppellets; 
    ArrayList<Pellets1> ppowerpellets;
    Fruit1 ffruit;
    Ghosts1[] gghosts;
    Pacman4 ppac;
    GameBorder ggb;
    String nname;
    HighScore[] hhighscores;
    

    /** Graphics added to Panel */
    public PacManGraphics(boolean endgame,ArrayList<Pellets1> pellets,Ghosts1[] ghosts,Pacman4 pac,ArrayList<Pellets1> powerpellets,GameBorder gb,int level,HighScore[] highscores, boolean startgame)
    {
        
        eatghost = Toolkit.getDefaultToolkit().getImage("eatghost.png");
        pacman = Toolkit.getDefaultToolkit().getImage("pacman.png");
        cherry = Toolkit.getDefaultToolkit().getImage("cherry.png");
        ghost1 = Toolkit.getDefaultToolkit().getImage("ghost1.png");
        ghost2 = Toolkit.getDefaultToolkit().getImage("ghost2.png");
        ghost3 = Toolkit.getDefaultToolkit().getImage("ghost3.png");
        ghost4 = Toolkit.getDefaultToolkit().getImage("ghost4.png");
        
        ggb=gb;
        ppellets= pellets;
        ppowerpellets=powerpellets;
        gghosts=ghosts;
        ghostimages = new Image[4];
        ghostimages[0]= ghost1;
        ghostimages[1]= ghost2;
        ghostimages[2]= ghost3;
        ghostimages[3]= ghost4;
        ppac=pac;
        endgamme=endgame;
        llevel=level;
        setBackground(Color.black);
        ddrawfruit=false;
        hhighscores=highscores;
        sstartgame=startgame;
    }
    public void updateFruit(Fruit1 fruit,boolean drawfruit)
      {
        ffruit=fruit;
        ddrawfruit=drawfruit;
      }
    public void updateLevel(int level)
      {
        llevel = level;
      }
    public void setGameOver()
     {
        endgamme = true;
     }
    /** Pac loc*/
     public void updateLocation(Pacman4 pac)
    {
      ppac=pac;
    }
    /** Pellets info*/
     public void updatePellets(ArrayList<Pellets1> pellets,ArrayList<Pellets1> powerpellets)
    {
      
      ppellets=pellets;
      ppowerpellets=powerpellets;
    }
    /** Pac hit ghost*/
    public void hitGhost(boolean endgame)
    {
      endgamme=endgame;
    }
    /** Ghosts timer*/
     public void updateGhosts(int eatghostcounter)
    {
      eeatghostcounter = eatghostcounter;
    }
    public void updateHighscores(HighScore[] highscores)
    {
        hhighscores=highscores;
    }
    public void updatestartgame(boolean startgame)
    {
        sstartgame=startgame;
    }
    public void paint (Graphics g)         
    {
      super.paint(g);
      
      g.setColor(Color.blue);
      /** Drawing Blue boarders*/
      g.drawRect(ggb.getXStart(),ggb.getYStart(),ggb.getXDimension(),ggb.getYDimension());
      
      g.drawRect(40,40,51,50);
      g.drawRect(309,40,51,50);
      g.drawRect(40,120,51,79);
      g.drawRect(309,120,51,79);
      
      g.drawRect(40,420,51,50);
      g.drawRect(309,420,51,50);
      g.drawRect(40,310,51,80);
      g.drawRect(309,310,51,80);
      
      g.drawRect(121,95,158,50);
      g.drawRect(121,40,158,25);
      g.drawRect(121,175,158,24);
      
      g.drawRect(121,365,158,50);
      g.drawRect(121,445,158,25);
      g.drawRect(121,310,158,25);
      
      g.drawRect(147+1/2,229,106-1/2,51);
      g.drawRect(40,229,77+1/2,51);
      g.drawRect(283-1/2,229,77+1/2,51);
      /** Drawing Powerpellets*/
      g.setColor(Color.yellow);
      for(index = 0; index < ppowerpellets.size(); index++)
      {
          g.setColor(Color.yellow);
          if (sstartgame)
          {
          if(ppowerpellets.get(index).getEaten() == false)
          g.fillOval(ppowerpellets.get(index).getX(), ppowerpellets.get(index).getY(), 20,20); 
        }
    }        
    /** Drawing Pellets*/
      for(index=0; index <= ppellets.size()-1; index++)
      {
         if (sstartgame)
         {
        if (ppellets.get(index).getEaten() == false)
        g.fillOval(ppellets.get(index).getX(),ppellets.get(index).getY(),10,10);
       }
    }
      for(index = 0; index < gghosts.length; index++)
      {
          if (sstartgame)
        {
          if(gghosts[index].getDidEat() == false)
          {
            /** Draw Ghost*/
            if(gghosts[index].getCanEat() == false)
              {
               g.drawImage(ghostimages[index],gghosts[index].getX(),gghosts[index].getY(),30,30,null);  
              }
            if(gghosts[index].getCanEat() == true)
             {
               /** Blue and Flashing Ghost*/
               if( eeatghostcounter > 500 && eeatghostcounter % 50 > 25)
                   g.drawImage(ghostimages[index],gghosts[index].getX(),gghosts[index].getY(),30,30,null);
               else g.drawImage(eatghost,gghosts[index].getX(),gghosts[index].getY(),30,30,null);

               
             }
                          
       }
      }
    }
       g.setColor(Color.yellow);
       
      if (ddrawfruit == true)
      {
      if (ffruit.getEaten()==false)
       g.drawImage(cherry,ffruit.getX(),ffruit.getY(),30,30,null);
    }
      
       g.setColor(Color.black);
        g.fillRect(7, 199, 5, 30);
        g.fillRect(387, 199, 5, 30);
      
      /** Draw Pac*/
      if (sstartgame)
      {
      g.drawImage(pacman,ppac.getX(),ppac.getY(),30,30,null);
    }
    
      /** Endgame when Pac hit ghost or end button pressed*/
      g.setColor(Color.red);
      if(ppac.getLives() == 0)
       {
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over",70,275);
        }
      /** Adding to score*/
      g.setFont(new Font("Arial", Font.BOLD, 20));
      g.drawString("Score:" + ppac.getScore(), 10,520);
      g.drawString("Level:" + llevel, 300, 520);
      
      g.drawString(hhighscores[0].getDisplayInfo(),80,545);
     
      
        g.drawString("Lives:",125,520);
        for( index = 0; index < ppac.getLives(); index++)
          {
            g.setColor(Color.yellow);
            g.fillOval(190 + index * 25,505, 20,20);
           }
       
        
        
        g.setColor(Color.blue);
        g.drawLine(5, 199, 10, 199);
        g.drawLine(5, 229, 10, 229); 
        g.drawLine(390, 199, 395, 199);
        g.drawLine(390, 229, 395, 229); 
        if (sstartgame==false)
        {
         
         g.setColor(Color.black);
         g.fillRoundRect(50,50,300,325,30,30);
         g.setColor(Color.blue);
         g.drawRoundRect(50,50,300,325,30,30);
         g.setColor(Color.yellow);
         g.setFont(new Font("Arial", Font.BOLD, 50));
         g.drawString("Pac-Man",100,100);
         g.setColor(Color.red);
         g.setFont(new Font("Arial", Font.BOLD, 35));
         int yval=150;
         for ( index=0; index<5; index++)
         {
         String display = hhighscores[index].gethighscorename();
         int slength= display.length()/2;
         if (display.length()%2==1)
         slength++;
         g.drawString(display,210-20*slength, yval+50*index);
         
        }
         
        }
   }
}
