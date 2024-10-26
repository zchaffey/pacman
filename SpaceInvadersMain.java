
/** SpaceInvaders Game
 *   @author (Zack Chaffey)
 *    @version (10/27/20)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpaceInvadersMain implements KeyListener, ActionListener
{
      	JFrame f1;
        JPanel main,sub;
        SpaceInvadersGraphics g1;
        int xdir,ydir,alienmissilecounter,randommissile,index,totalAliens,totalshots,totalalienshots,totalfastshots,i;
        JButton b1,b2;
        int[] amx,amy;
        boolean endgame,startgame,alienshot,shottaken,speedshot;
        Alien1[] aliens;
        Missile[] missiles,lasermissiles;
        SpaceShip sp;
        



	public SpaceInvadersMain()
	{
	    randommissile=(int)(Math.random() *20);
	    alienmissilecounter=200;
	    sp= new SpaceShip(190,428);
	    xdir = 0;
	    ydir = 0;
	    speedshot = false;
	    alienshot = false;
	    endgame = false;
	    shottaken = false;
	    startgame = false;
	    amx = new int[500];
	    amy = new int[500];
	    alienmissilecounter=0;
	    missiles = new Missile[500];
	    totalshots=0;
	    lasermissiles= new Missile[500];
	    totalfastshots=0;
	    totalAliens= 20;
	    aliens = new Alien1[totalAliens];
	       for (index=0; index <=totalAliens-1; index++)
	    {
	       
	        if (index <=9) aliens[index] = new Alien1(index * 40 + 5,10);
	        if (index >9) aliens[index]= new Alien1(index * 40 - 395,50); 
	       
	    }
	    
	    
	    
	    f1 = new JFrame("Space Invaders");
	      f1.setSize(416,550);
	      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f1.setResizable(false);
	     
	    
	    Container c1 = f1.getContentPane();
	    
	    b1=new JButton("Start");
	    b1.addActionListener(this);
	    b2=new JButton("End");
	    b2.addActionListener(this);
	    
	      
	    
	    g1 = new SpaceInvadersGraphics(shottaken,alienshot,speedshot,aliens,sp);
	     g1.addKeyListener(this);
	     
	     sub = new JPanel(); 
	      sub.add(b1);
	      sub.add(b2);
	                                  
	    main = new JPanel();
	      main.setLayout(new BorderLayout());    
	      main.setSize(600,600);
	      main.add(g1,BorderLayout.CENTER);
	      main.add(sub,BorderLayout.SOUTH);
	    
	  
	    
	    c1.add(main);
	    
	    f1.show();
	    
	    runGame();
	    
	    
	}
	public void runGame()
	{
	    Thread runner = new Thread();
	    while(endgame == false)
	  {	
	    try 
	      { 
	        runner.sleep(5); 
	       }
	      catch(InterruptedException e) {} 
	      
	    if (startgame == true)
	    {
	        
	        if (sp.getX() > 360) 
	      {  
	        xdir = 0;
	        sp.setShiploc(360,428);  
	       }
	       
	        if (sp.getX() < 0) 
	      {
	        xdir = 0;
	        sp.setShiploc(0,428);  
	       }
	       
	     sp.moveShip(xdir,ydir);
	    
	     if (speedshot == true)
	     { 
	         for(index = 0; index<totalfastshots; index++)
               {
	           lasermissiles[index].moveMissile(0,-5);
	          }
	       g1.updatefastMissileLocation(speedshot,totalfastshots,lasermissiles);
	     } 
	        if(shottaken ==true)
	    {
	      for(index=0; index < totalshots; index++)
	      {
	       missiles[index].moveMissile(0,-1);
	       }
	       
	      g1.updateMissileLocation(shottaken,totalshots,missiles);
	    }
	   
	    if (alienmissilecounter ==100)
	    {   randommissile=(int)(Math.random() *20);
	        alienshot=true;
	         if ( aliens[randommissile].getDestroyed()==false)
	        {   
	            amx[totalalienshots]=aliens[randommissile].getX()+10;
	            amy[totalalienshots]=aliens[randommissile].getY()+30;
	            totalalienshots=totalalienshots+1;
	          }
	         
	          alienmissilecounter=0;
	      }
	        for(index=0; index < totalalienshots; index++)
	          {
	            amy[index]=amy[index]+3;
	        }
	      alienmissilecounter = alienmissilecounter +1;
	      
	    
	    for(index=0; index < totalalienshots; index++)
	          {
	        if (amx[index] - sp.getX() <= 40 && amx[index] - sp.getX() >= 0 && amy[index] - sp.getY() <= 40 && amy[index] - sp.getY() >= 0) 
	      {
	       endgame= true;
	       g1.hitMissile(endgame);
	      }
	    } 
	    for(index=0; index < totalshots; index++)
	    { for(i=0; i < aliens.length; i++)
	        { if(missiles[index].getX() > aliens[i].getX() - 15 && missiles[index].getX() < aliens[i].getX() + 15 && missiles[index].getY() > aliens[i].getY() - 15 && missiles[index].getY() < aliens[i].getY() + 15 && aliens[i].getDestroyed() == false)
                  {
                      aliens[i].destroyAlien();
                      sp.addScore(100);
                   }
	           }
	       }
	       for(index=0; index < totalfastshots; index++)
	    { for(i=0; i < aliens.length; i++)
	        { if(lasermissiles[index].getX() > aliens[i].getX() - 15 && lasermissiles[index].getX() < aliens[i].getX() + 15 && lasermissiles[index].getY() > aliens[i].getY() - 15 && lasermissiles[index].getY() < aliens[i].getY() + 15 && aliens[i].getDestroyed() == false)
                  {
                      aliens[i].destroyAlien();
                      sp.addScore(100);
                   }
	           }
	       }
	    g1.updateAlien(aliens);
	    g1.updatePlayerLocation(sp);
	    g1.updateAlienMissile(amx,amy,alienshot,totalalienshots);
            g1.repaint();
           }
	 }
	}
	public void actionPerformed (ActionEvent event)
	{
	    if (event.getSource() == b1)
	    {
	        startgame=true;
	        g1.requestFocus();
	     }
	     
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
        if(evt.getKeyCode() == 37)      
           {
              xdir = -1;
              ydir = 0;
           }
           if(evt.getKeyCode() == 39)    
           {
              xdir = 1;
              ydir = 0;
           }
           if(evt.getKeyCode() == 32)
           {
               missiles[totalshots]= new Missile(sp.getX()+5,sp.getY()-10);
               totalshots= totalshots +1;
               shottaken = true;
            }
        if (evt.getKeyCode() == 90)
        { lasermissiles[totalfastshots]= new Missile(sp.getX()+5,sp.getY()-10);
          totalfastshots = totalfastshots +1;
          speedshot = true;
          
        }
        
    }
}
