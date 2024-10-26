
/**
 * Pacman Game
 *
 * @author (Zack Chaffey)
 * @version (10/27/20)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
/** Import Print */
import java.io.*;
import java.awt.print.*;
/** Import Dates */
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/** Import Music*/
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PacMan implements KeyListener, ActionListener, Printable
{
    JFrame f1;
    JPanel main,sub;
    PacManGraphics g1;
    Container c1;
    JButton b1,b2;
    int index,px,py,i,level,optionnumberchosen,newscore,newhighscore,highscore,ynprint;
    int totalghosts,ghrandomdir,eatghostcounter,levelpausecounter,fruitcounter;
    boolean endgame,startgame,caneatghosts,drawfruit,oktoprint;
    Ghosts1[] ghosts;
    ArrayList<Pellets1> pellets;
    ArrayList<Pellets1> powerpellets;
    Fruit1 fruit;
    Pacman4 pac;
    GameBorder gb;
    String desireddirection,highscoreS,name,newscoreS;
    Clip audio1,audio2,audio3,audio4,audio5;
    ImageIcon icon;
    Image coa,cb,as,ad,ahs;
    HighScore[] highscores;
    PrinterJob job;
    PageFormat pf;
    Date todaysdate;
    SimpleDateFormat monthfull,dayofweekshort,yearfull;
    
          public PacMan()
    {
       
        setInitialValues();
        
        makeArrays();
        
        addMusic();
        
        pac = new Pacman4(185,335);
        gb= new GameBorder(10,10,380,490);
        
        makePowerPellets();
        
        makePellets();
       
        makeGhosts();
    
        setupFrame();
    
        c1.add(main);
          
        f1.show();
        runGame();
    }
     public void runGame()
     {
        Thread runner = new Thread();
         
      while(endgame == false)
        {      
            /** Slow down Computer*/
            try 
          { 
            runner.sleep(12); 
           }
          catch(InterruptedException e) {}  
          if (startgame == true && levelpausecounter <= 0)
       {
        movePac();
         if(audio2.getMicrosecondPosition() >= audio2.getMicrosecondLength())
        {
               audio2.setMicrosecondPosition(0);
          }
        if(audio3.getMicrosecondPosition() >= audio3.getMicrosecondLength())
           {
               audio3.setMicrosecondPosition(0);
            }
        if(audio4.getMicrosecondPosition() >= audio4.getMicrosecondLength())
           {
               audio4.setMicrosecondPosition(0);
            }
        if(audio5.getMicrosecondPosition() >= audio5.getMicrosecondLength())
           {
               audio5.setMicrosecondPosition(0);
            }
        
        PacEatPellets();
        
         if(pellets.size() == 0 && powerpellets.size() == 0)
            {  
              nextLevel();
             } 
        
        PacHitGhost();
        
        moveGhost();
        
        PacEatPP();
        
        checkGhostsIfCanEat();
        if(pac.getLives() == 0)
             {
               endgame = true;
               newhighscore=pac.getScore();
               
               highscores=HighScoreSorter.HighScoreS(highscores,newhighscore,name,f1,icon);
           
               updateHighScoresToFile();
               g1.setGameOver();
             }  
        
           
            /** Send Info to GP*/
        g1.updateLocation(pac);
        g1.updatePellets(pellets,powerpellets);
        g1.updateGhosts(eatghostcounter);
        g1.repaint();
    
        }
        else
        {
            levelpausecounter--;
        }
       }
        }
    private void setInitialValues()
    {
        caneatghosts=false;
        endgame = false;
        startgame = false;
        drawfruit = false;
        desireddirection = "";
        totalghosts=4;
        levelpausecounter=500;
        level=1;
        getCurrentHighScoresFromFile();
        
    }
    private void addMusic()
    {
        levelpausecounter=500;
        try {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("pacman_beginning.wav"));
                audio1 = AudioSystem.getClip();
                audio1.open(audioIn);
                   
                AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(new File("pacman_chomp.wav"));
                audio2 = AudioSystem.getClip();
                audio2.open(audioIn2);
                
                AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(new File("pacman_death.wav"));
                audio3 = AudioSystem.getClip();
                audio3.open(audioIn3);
                
                AudioInputStream audioIn4 = AudioSystem.getAudioInputStream(new File("pacman_eatghost.wav"));
                audio4 = AudioSystem.getClip();
                audio4.open(audioIn4);
                
                AudioInputStream audioIn5 = AudioSystem.getAudioInputStream(new File("pacman_intermission.wav"));
                audio5 = AudioSystem.getClip();
                audio5.open(audioIn5);
    
                
             } catch(Exception ex) 
                   {
                       System.out.println("Error with playing sound.");
                       ex.printStackTrace();
                    }
    }
    private void makeArrays()
    {
        ghosts = new Ghosts1[totalghosts];
        pellets = new ArrayList<Pellets1>();
        powerpellets = new ArrayList<Pellets1>();
    }
    private void makePowerPellets()
    {
        /**Powerpellets Loc*/
       powerpellets.add(new Pellets1(55,95));
       powerpellets.add(new Pellets1(55,395));
       powerpellets.add(new Pellets1(325,95));
       powerpellets.add(new Pellets1(325,395));
    }
    private void makePellets()
    {
        /**Normal Pellets Loc*/
    for (index =0; index < 14; index++)
    {  
          pellets.add(new Pellets1(index*27+20,20));
          pellets.add(new Pellets1(index*27+20,480));
       }  
    for (index =0; index < 16; index++)
    {  
        pellets.add(new Pellets1(20,index*27+47));
        pellets.add(new Pellets1(371,index*27+47));
     }
     for (index =0; index < 12; index++)
    {  
       pellets.add(new Pellets1(index*27+47,209));
       pellets.add(new Pellets1(index*27+47,290));
     }
     for (index =0; index < 6; index++)
    {  
       pellets.add(new Pellets1(101,index*27+47));
       pellets.add(new Pellets1(290,index*27+47));
       pellets.add(new Pellets1(290,index*27+317));
       pellets.add(new Pellets1(101,index*27+317));

           pellets.add(new Pellets1(index*27+128,74));
           pellets.add(new Pellets1(index*27+128,155));
           pellets.add(new Pellets1(index*27+128,425));
     }
     for (index =0; index < 2; index++)
    {  
        pellets.add(new Pellets1(index*27+128,344));
        pellets.add(new Pellets1(index*27+236,344));
        
        pellets.add(new Pellets1(128,index*27+236));
        pellets.add(new Pellets1(263,index*27+236));
          }
    }
     private void makeGhosts()
     {
         /**Ghosts Loc*/
    ghosts[0]= new Ghosts1(185,145);
    ghosts[1]= new Ghosts1(185,145);
    ghosts[2]= new Ghosts1(185,145);
    ghosts[3]= new Ghosts1(185,145);
     }
     private void resetGhosts()
      {
        for(index=0; index<ghosts.length; index++)
        {
        ghosts[index].setDidEat(false);
        ghosts[index].setCanEat(false);
    }
        ghosts[0].setLocation(185,145);
        ghosts[1].setLocation(185,145);
        ghosts[2].setLocation(185,145);
        ghosts[3].setLocation(185,145);
        
        for(index =0; index < ghosts.length; index++)
           {  
               randomghostdir();
               
           }

        for(int index = 0; index < ghosts.length; index++)
          { 
            ghosts[index].increaseSpeed();                 
          }
       
       }
     private void setupFrame()
     {
         /** Frame */
        f1 = new JFrame("Pacman");
          f1.setBounds(0,0,420,630);
          f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
          f1.setResizable(false);
         
         c1 = f1.getContentPane();
         /** Send to GP*/
        g1 = new PacManGraphics(endgame,pellets,ghosts,pac,powerpellets,gb,level,highscores,startgame);
          g1.addKeyListener(this);
        
        /** Start and End buttons*/
        b1=new JButton("Start");
      b1.addActionListener(this);
      b2=new JButton("End");
      b2.addActionListener(this);
      
      
      
      icon = new ImageIcon("smallpac.png");
        
    /** Sub Panels */
        sub = new JPanel();
        sub.add(b1);
        sub.add(b2);
        /** Main Panel */
         main = new JPanel();
          main.setLayout(new BorderLayout());
          main.setSize(600,600);
          main.add(g1,BorderLayout.CENTER);
          main.add(sub,BorderLayout.SOUTH);
          sub.setBackground(Color.black);
        
     }
    
        public void getCurrentHighScoresFromFile()
        {
           highscores=Reader.readfile();
        }
        public void updateHighScoresToFile()
       {
           newscore=pac.getScore();
           
          
           Writer.writefile(highscores);
        
           g1.updateHighscores(highscores);
           g1.repaint();
           GettingTodaysDate();
           Print_certificate();
         }
        private void GettingTodaysDate()
        {
           todaysdate = Calendar.getInstance().getTime();
           
           monthfull = new SimpleDateFormat("MMMM");
           dayofweekshort = new SimpleDateFormat("dd");
           yearfull = new SimpleDateFormat("YYYY");
        }
        private void Print_certificate()
        {
           coa = Toolkit.getDefaultToolkit().getImage("Certificate Of Achievement.png");
           cb = Toolkit.getDefaultToolkit().getImage("Certificate Border.png");
           as = Toolkit.getDefaultToolkit().getImage("Award Seal.png");
           ad = Toolkit.getDefaultToolkit().getImage("Award Date.png");
           ahs = Toolkit.getDefaultToolkit().getImage("Achieving High score.png");

           job = PrinterJob.getPrinterJob();
           pf = job.defaultPage();
           pf.setOrientation(PageFormat.LANDSCAPE);
           job.setPrintable(this,pf);
           
           ynprint = JOptionPane.showConfirmDialog(f1,"Would you like to print a certificate?","Print Certificate",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
           if (ynprint == 0)
           {
               oktoprint = job.printDialog();
               
               if (oktoprint == true)
               {
                   try
                   {
                       job.print();
                    } catch (PrinterException ex) {}
                }
            }
        }
        public int print(Graphics g, PageFormat pf, int page) throws PrinterException
        {
            if (page >0)
            {
                return NO_SUCH_PAGE;
            }
            g.drawImage(cb,10,10,800,600,null);
            g.drawImage(coa,100,100,600,150,null);
            g.drawImage(ad,100,325,500,50,null);
            g.drawImage(ahs,150,400,500,50,null);
            g.drawImage(as,350,450,100,100,null);
            g.setColor(Color.black);
            g.drawLine(100,300,750,300);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString(name,350,300);
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.drawString(""+newscore,450,430);
            g.setFont(new Font("Arial",Font.BOLD,20));
            g.drawString(dayofweekshort.format(todaysdate)+"             "+monthfull.format(todaysdate)+"              "+yearfull.format(todaysdate),285,355);
            
            
            return PAGE_EXISTS;
        }
        private void movePac()
        {
            /** Move Pacman */
        pac.checkNewDirection(desireddirection);
        pac.movePacMan(gb);
        }
        private void resetPac()
        {
           pac.setLocation(185,335);
           pac.setspeed();
           pac.checkNewDirection("");

        }
        private void PacEatPellets()
        {
            /**Pac eat Pellets*/
        for(index = 0; index <= pellets.size()-1; index++)
        {
            if(pac.getX() >= pellets.get(index).getX() - 20 && pac.getX() <= pellets.get(index).getX() + 10 && pac.getY() >= pellets.get(index).getY() - 10 && pac.getY() <= pellets.get(index).getY() + 10 )
            {
                audio2.start();
                pellets.remove(index);
                pac.addScore(10);
             }
         }
         if(pellets.size()==100)
         {    fruit = new Fruit1(185,199);
              drawfruit=true;
              g1.updateFruit(fruit,drawfruit);
              fruitcounter=1000;
           }
         if(pellets.size()==53 && drawfruit==false)
         {
             fruit = new Fruit1(185,199);
             drawfruit=true;
             fruitcounter=1000;
            }
           PacEatfruit();
           
        }
        private void PacEatfruit()
        {
         
            if (drawfruit==true )
          {
            if(pac.getX() > fruit.getX() - 30 && pac.getX() < fruit.getX() + 30 && pac.getY() > fruit.getY() - 30 && pac.getY() < fruit.getY() + 30 && fruit.getEaten() == false)
              {
                  pac.addScore(100*level);
                  fruit.EatIt();
                  drawfruit=false;
              }
            if (fruitcounter ==0)
            {
                drawfruit=false;
                fruit.setEaten(false);
                
            }
            fruitcounter--;
            g1.updateFruit(fruit,drawfruit);
            }
            
          
        
        }
        private void nextLevel()
        {
          audio5.start();
          resetGhosts();
          resetPac();
          makePellets();
          makePowerPellets();
          levelpausecounter = 500;
          fruit.setEaten(false);
          level++;
          g1.updateLevel(level);
        }
        private void PacHitGhost()
        {
             /** Pac hitting Ghosts */
        if (caneatghosts == false)
        {
         for(index = 0; index <= ghosts.length-1; index++)
        {
            if(pac.getX() >= ghosts[index].getX() - 20 && pac.getX() <= ghosts[index].getX() + 20 && pac.getY() >= ghosts[index].getY() - 20 && pac.getY() <= ghosts[index].getY() + 20 && ghosts[index].getGhit() == false && ghosts[index].getDidEat() == false)
            {
               audio3.start();
                pac.pacDied();
                   levelpausecounter = 500;
                   resetPac();
                   for(index=0; index<ghosts.length; index++)
               {
                  ghosts[index].setDidEat(false);
                  ghosts[index].setCanEat(false);
                }
               ghosts[0].setLocation(185,145);
               ghosts[1].setLocation(185,145);
               ghosts[2].setLocation(185,145);
               ghosts[3].setLocation(185,145);
        
                 for(index =0; index < ghosts.length; index++)
            {  
               randomghostdir();
               
             }
             }
             g1.hitGhost(endgame);
         } 
       }
        }
        private void moveGhost()
        {
             /** Ghost Movement */
        for (index=0; index < ghosts.length; index++)
           {
             
             ghosts[index].moveGhost(gb,pac);
           }
            for(index = 0; index < ghosts.length; index++)
            {
                
                ghosts[index].changeDirectionRandom();
                /**ghosts[index].changeDirectionChase(pac);
                if(ghosts[index].getCanEat() == true)
                ghosts[index].changeDirectionRun(pac);*/
            } 
        }
        private void PacEatPP()
        {
             /** Pac eat Powerpellets */
                 for(index = 0; index < powerpellets.size(); index++)
            {
                if(pac.getX() > powerpellets.get(index).getX() - 20 && pac.getX() < powerpellets.get(index).getX() + 20 && pac.getY() > powerpellets.get(index).getY() - 20 && pac.getY() < powerpellets.get(index).getY() + 20  )
              {
                  audio2.start();
                  powerpellets.remove(index);
                  eatghostcounter = 0;
                  caneatghosts = true;
                  pac.addScore(50);
                  /** Allow Pac to eat Ghosts*/
                     for(i = 0; i < ghosts.length; i++)
                  {
                        ghosts[i].setCanEat(true);
                     }
              }
            }
        }
        private void checkGhostsIfCanEat()
        {
              /** Pac eat Ghost*/
       if(caneatghosts == true) 
         {      
            eatghostcounter = eatghostcounter + 1;
          for(index = 0; index < ghosts.length; index++)
            {
                if(pac.getX() > ghosts[index].getX() - 30 && pac.getX() < ghosts[index].getX() + 30 && pac.getY() > ghosts[index].getY() - 30 && pac.getY() < ghosts[index].getY() + 30 && ghosts[index].getCanEat() == true && ghosts[index].getDidEat() == false)
              {
                  audio4.start();
                  pac.addScore(200);
                  ghosts[index].setDidEat(true);
              }
           }
           if(eatghostcounter >= 800)
           {
               caneatghosts = false;

               for(index = 0; index < ghosts.length; index++)
                 {  
                  ghosts[index].setCanEat(false);
                 }
           }
         }
        }
       public void randomghostdir()
       {
            int randomnum= (int)(Math.random()*2+1);
               if (randomnum == 1)
               {
                   ghosts[index].setghostsdir(1,0);
               }
               if (randomnum == 2)
            {
                ghosts[index].setghostsdir(-1,0);
            }
       }
        public void actionPerformed (ActionEvent event)
    {
        /** Start button Pressed*/
        if (event.getSource() == b1)
        {
           /** Set Ghost dir */
            for(index =0; index < ghosts.length; index++)
           {  
              randomghostdir();
           }
            audio1.start();
            levelpausecounter=500;
            startgame = true;
            g1.updatestartgame(startgame);
            g1.requestFocus();
         }
        /** End game button Pressed */
        if (event.getSource() == b2)
        {
           endgame = true;
           f1.dispose();
         }
         
         
     }
    
    
    public void keyReleased(KeyEvent evt) {}
    public void keyTyped(KeyEvent evt) {}
    
    public void keyPressed(KeyEvent evt)
    {
            /** Up arrow pressed*/
              if(evt.getKeyCode() == 38)
           {
              desireddirection = "up";
           }
            /** Down arrow pressed*/
           if(evt.getKeyCode() == 40)
           {
              desireddirection = "down";
           }
            /** Left arrow pressed*/
           if(evt.getKeyCode() == 37)
           {
              desireddirection = "left";
           }
            /** Right arrow pressed*/
           if(evt.getKeyCode() == 39)
           {
              desireddirection = "right";
           }
           
           if(evt.getKeyCode() == 80)
           {
               startgame=false;
               optionnumberchosen = JOptionPane.showConfirmDialog(f1,"Would you like to pause the game?","Pause Game",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               if(optionnumberchosen==1)
               {
                   startgame=true;
                }
                if(optionnumberchosen==0)
               {
                  JOptionPane.showMessageDialog(f1, "Press OK to resume", "Resume Game",JOptionPane.QUESTION_MESSAGE);
                   startgame=true;
                }
            }
         
        
    }
  
}
