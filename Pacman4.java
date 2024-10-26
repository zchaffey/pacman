
public class Pacman4 extends MoveableGameObject
{
   
   int score,lives;
   String dd;
    public Pacman4(int xx, int yy)
    {
        super(xx,yy);
        score = 0;
        speed=1.2;
        dd="";
        lives=3;
    }

   
    
    public void setLocation(int xx, int yy)
    {
       x = xx;
       y = yy;    
    }   
    public void setspeed()
    {
        xdir=0;
        ydir=0;
    }
    public int getLives()
     {
        return lives;
     }

     public void pacDied()
     {
       lives--;   
      }
   
      public void checkNewDirection(String d)
    {
        dd=d;
          if((getY()==10 || getY() == 11) || ((getY()==65 || getY()==66) && (getX()>=91 && getX()<=279)) || ((getY()==145 || getY()== 146) && (getX()>=91 && getX()<=279)) || (getY()==199 || getY()== 200) || (getY()==280 || getY()== 281) || ((getY()==335 || getY()==336) && (getX()>=91 && getX()<=279)) || ((getY()==415 || getY()==416) && (getX()>=91 && getX()<=279)) || (getY()==470 || getY()== 471) || ((getY()==90 || getY()==91) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) || ((getY()==390 || getY()==391) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) )
      {
        if(dd.equals("left"))    
              {
              xdir = -1*speed;
              ydir =   0;
                }
        if(dd.equals("right"))    
            {
              xdir = 1*speed;
              ydir =  0;
             }
             if(getY() == 11 || getY() == 66 || getY() == 91 || getY() == 146 || getY() == 200 || getY() == 281 || getY() == 336 || getY() == 391 || getY()== 416 || getY() == 471)
         {
             y = y - 1;
             }
             
      }
        if((getX()==10 || getX() == 11) || ((getX()==117 || getX()==118) && (getY()>=199 && getY()<=280)) || ((getX()==253 || getX()== 254) && (getY()>=199 && getY()<=280)) || ((getX()==91 || getX()== 92) && ((getY()>=10 && getY()<= 199) || (getY()>=280 && getY()<=470))) || (getX()==360 || getX()==361) || ((getX()==279 || getX()==280) && ((getY()>=10 && getY()<=199) || (getY()>=280 && getY()<=470))) )
     {
        if(dd.equals("up"))    
            {
              xdir =  0;
              ydir = -1*speed;
             }
        if(dd.equals("down"))    
            {
              xdir =  0;
              ydir = 1*speed;
             }
             if(getX() == 11 || getX() == 92 || getX() == 118 || getX() == 186 || getX() == 254 || getX() == 280 || getX() == 361)
          {
              x = x - 1;
             }
        
      }
     }
     public void movePacMan(GameBorder gb)
     {
         moveIt();
         if (xdir==1*speed)
         { 
          
           if (getX()>279 && (getY()== 415||getY()== 65||getY()==145||getY()== 335))
           {x=279;
            xdir=0*speed;
            }
           
           if (getX()>=91 && getX()<=93 && getY()== 90)
           {x=91;
            xdir=0*speed;
            }
           if (getX()>=91 && getX()<=93 && getY()== 390)
           {x=91;
            xdir=0*speed;
            }
          
        }
         if (xdir==-1*speed)
         { 
           
           if (getX()>=277 && getX()<=279 && getY()== 90)
           {x=279;
            xdir=0*speed;
            }
           if (getX()<91 && (getY()== 65||getY()== 145||getY()== 335||getY()== 415))
           {x=91;
            xdir=0*speed;
            }
           if (getX()>=277 && getX()<=279 && getY()== 390)
           {x=279;
            xdir=0*speed;
            }
          
        }
         if (ydir==-1*speed)
         { 
           if (getX()==91 && getY()>= 278 && getY()<=280)
           {y=280;
            ydir=0*speed;
            }
           
           if (getX()==279 && getY()>= 278 && getY()<=280)
           {y=280;
            ydir=0*speed;
            }
           if ((getX()==253 || getX()==117) && (getY()< 199))
           {y=199;
            ydir=0*speed;
            }
           
           
          
        }
        if (ydir==1*speed)
         { 
           if (getX()==91 && getY()>=199 && getY()<=201)
           {y=199;
            ydir=0*speed;
            }
           if (getX()==279 && getY()>=199 && getY()<=201)
           {y=199;
            ydir=0*speed;
            }
           if ((getX()==253||getX()==117) && getY()> 280)
           {y=280;
            ydir=0*speed;
            }
           
           
          
        }
         if(x < gb.getXStart() && getY() != 199)        
             {
              x = gb.getXStart();               
             } 
         if(x < gb.getXStart() - 30 && getY() == 199)     
             {
                x = gb.getXStart() + gb.getXDimension();  
             }
             
         if(x > gb.getXStart() + gb.getXDimension() -30 && getY() != 199)        
             {
              x = gb.getXStart() + gb.getXDimension() -30;             
             } 
         if(x > gb.getXStart()+ gb.getXDimension() && getY() == 199)     
             {
                x = gb.getXStart(); 
             }
         
         if(y< gb.getYStart())
         y=gb.getYStart();
         if(y> gb.getYStart() + gb.getYDimension() - 30)
            y = gb.getYStart() + gb.getYDimension() - 30;
     }
     
     
     public void setPacManloc(int xx, int yy)
     {
       x = xx;
       y = yy;
        
      }
    public void addScore(int amt)
    {
        score = score + amt;
    }  
    
    public int getScore()
    {
        return score;
    }   
  
 }
        
        
    
    
    