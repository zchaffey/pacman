
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class SpaceInvadersGraphics  extends JPanel
{
     Image space,invader,bullet,player,bang;
     int index,ttotalshots,ttotalalienshots,ttotalfastshots;
     int[] aamx,aamy;
     boolean sstartgame,shottakenn,aalienshot,sspeedshot,eendgame;
     Alien1[] aaliens;
     Missile[] mmissiles,llasermissiles;
     SpaceShip ssp;
      
    public SpaceInvadersGraphics(boolean shottaken,boolean alienshot, boolean speedshot,Alien1[] aliens, SpaceShip sp )               
  {
        invader = Toolkit.getDefaultToolkit().getImage("alien2.gif");
        space = Toolkit.getDefaultToolkit().getImage("space1.png");
        bullet = Toolkit.getDefaultToolkit().getImage("rocket.png");
        player = Toolkit.getDefaultToolkit().getImage("spaceship.png");
        bang = Toolkit.getDefaultToolkit().getImage("bang.png");
        aaliens= aliens;
        ssp=sp;
        shottakenn = shottaken;
        sspeedshot = speedshot;
        aalienshot =alienshot;
    }
    
    public void updatePlayerLocation(SpaceShip sp)
    {
      ssp=sp;
    }
    public void updateMissileLocation( boolean shottaken,int totalshots,Missile[] missiles)
    {
        mmissiles= missiles;
        shottakenn = shottaken; 
        ttotalshots = totalshots;
    }
    public void updatefastMissileLocation(boolean speedshot,int totalfastshots, Missile[] lasermissiles)
    {
        llasermissiles= lasermissiles;
        sspeedshot = speedshot; 
        ttotalfastshots = totalfastshots;
    }
    public void updateAlien(Alien1[] aliens)
    {
        aaliens=aliens;
    }
    public void updateAlienMissile(int[] amx,int[] amy,boolean alienshot,int totalalienshots)
    {
      aamx = amx;
      aamy = amy;
      aalienshot=alienshot;
      ttotalalienshots=totalalienshots;
    }
    public void hitMissile(boolean endgame)
    {
      eendgame=endgame;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g);
        
       
       
        g.drawImage(space,0,0,400,500,null);  
                                             
        
        
        
        g.drawImage(player,ssp.getX(),428,40,40,null);
        
        
        
        g.setColor(Color.white);
        
        g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score:" + ssp.getScore(), 10,300); 
        
        for (index=0; index<aaliens.length; index++)
        {     if (aaliens[index].getDestroyed() == false)
            {  
             
                g.drawImage(invader,aaliens[index].getX(),aaliens[index].getY(),30,30,null);
               
            }
            else
            {   
                g.drawImage(bang,aaliens[index].getX(),aaliens[index].getY(),30,30,null);
                
            }
        }
       
         if(shottakenn == true)
       {
            for(index = 0; index<ttotalshots; index++)
          {   
            g.drawImage(bullet,mmissiles[index].getX(),mmissiles[index].getY(),30,50,null);
            }
        }
        if(sspeedshot == true)
       {
          for(index = 0; index<ttotalfastshots; index++)
           {
           g.drawImage(bullet,llasermissiles[index].getX(),llasermissiles[index].getY(),30,50,null);
        }
        }
        
        if (aalienshot == true)
      { g.setColor(Color.red);
        for(index = 0; index<ttotalalienshots; index++)
        g.fillOval(aamx[index],aamy[index],10,10);
     } 
     if(eendgame == true)
       {
           g.drawImage(bang,ssp.getX(),428,40,40,null);
           g.setFont(new Font("Arial", Font.BOLD, 50));
           g.drawString("Game Over",70,250);
        }
      
     }    
        
}
