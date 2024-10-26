

public class Ghosts1 extends MoveableGameObject
{
     
     int randomdirection;
     boolean ghit,caneat,dideat;
    public Ghosts1(int xx, int yy)
    {
      super(xx,yy);
      xdir = 0;
      ydir = 0;
      ghit = false;
      caneat = false;
      dideat = false;
      speed=1.0;
    }
    public void setghostsdir(int xxdir, int yydir)
    
    {
        xdir= xxdir;
        ydir= yydir;
    }
    
    
    
    public boolean getGhit()
    {
        return ghit;
    }

    
    public void hitGhost()
    {
       ghit = true;
    }
    
    public boolean getCanEat()
     {
       return caneat;
      }
      
    public void setCanEat(boolean ce)
    {
        caneat = ce;
    }
    
    public boolean getDidEat()
    {
        return dideat;
    }
    
    public void setDidEat(boolean de)
    {
        dideat = de;
    }   
    
    public void moveGhost(GameBorder gb,Pacman4 pac)
    {
        moveIt();
        boolean newdirection=false;
      
         if (xdir==1*speed)
         { 
          
           if ((getX()>279 && getX()<282) && (getY()== 415||getY()== 65||getY()==145||getY()== 335))
           {x=279;
            xdir=0*speed;
            newdirection=true;
            }
           
           if (getX()>=91 && getX()<=93 && getY()== 90)
           {x=91;
            xdir=0*speed;
            newdirection=true;

            }
           if (getX()>=91 && getX()<=93 && getY()== 390)
           {x=91;
            xdir=0*speed;
            newdirection=true;

            }
            if (newdirection==true)
            {
            if(getX() == 11 || getX() == 92 || getX() == 118 || getX() == 186 || getX() == 254 || getX() == 280 || getX() == 361)
          {
              x = x - 1;
             }
            }
        }
         if (xdir==-1*speed)
         { 
           
           if (getX()>=277 && getX()<=279 && getY()== 90)
           {x=279;
            xdir=0*speed;
            newdirection=true;

            }
           if (getX()<91 && (getY()== 65||getY()== 145||getY()== 335||getY()== 415))
           {x=91;
            xdir=0*speed;
            newdirection=true;

            }
           if (getX()>=277 && getX()<=279 && getY()== 390)
           {x=279;
            xdir=0*speed;
            newdirection=true;

            }
            if (newdirection==true)
            {
             if(getX() == 11 || getX() == 92 || getX() == 118 || getX() == 186 || getX() == 254 || getX() == 280 || getX() == 361)
          {
              x = x - 1;
             }
            }
        }
         if (ydir==-1*speed)
         { 
           if (getX()==91 && getY()>= 278 && getY()<=280)
           {y=280;
            ydir=0*speed;
            newdirection=true;

            }
           
           if (getX()==279 && getY()>= 278 && getY()<=280)
           {y=280;
            ydir=0*speed;
            newdirection=true;

            }
           if ((getX()==253 || getX()==117) && (getY()< 199))
           {y=199;
            ydir=0*speed;
            newdirection=true;

            }
            if (newdirection==true)
            {
            if(getY() == 11 || getY() == 66 || getY() == 91 || getY() == 146 || getY() == 200 || getY() == 281 || getY() == 336 || getY() == 391 || getY()== 416 || getY() == 471)
         {
             y = y - 1;
             }
            }
          
        }
        if (ydir==1*speed)
         { 
           if (getX()==91 && getY()>=199 && getY()<=201)
           {y=199;
            ydir=0*speed;
            newdirection=true;

            }
           if (getX()==279 && getY()>=199 && getY()<=201)
           {y=199;
            ydir=0*speed;
            newdirection=true;

            }
           if ((getX()==253||getX()==117) && getY()> 280)
           {y=280;
            ydir=0*speed;
            newdirection=true;

            }
            if (newdirection==true)
            {
             if(getY() == 11 || getY() == 66 || getY() == 91 || getY() == 146 || getY() == 200 || getY() == 281 || getY() == 336 || getY() == 391 || getY()== 416 || getY() == 471)
         {
             y = y - 1;
             }
            }
        }
                 
        if(x< gb.getXStart())
        {
         newdirection=true;
         x=gb.getXStart();
        }
         if(x > gb.getXStart() + gb.getXDimension() - 30)
          {   newdirection=true;
              x = gb.getXStart() + gb.getXDimension() - 30;
            }
         if(y< gb.getYStart())
         {
         newdirection=true;
         y=gb.getYStart();
        }
         if(y > gb.getYStart() + gb.getYDimension() - 30)
          {   newdirection=true;
              y = gb.getYStart() + gb.getYDimension() - 30;
            }
            
            if(newdirection==true)
       { changeDirectionChase(pac);
        }
    }  
    
    public void changeDirectionChase(Pacman4 pac)
    {
 
        xdir = 0; 
        ydir = 0; 
        
        randomdirection = (int)(Math.random()  * 4 + 1);
         if(randomdirection == 1)
        {
           if((getY()==10 || getY() == 11) || ((getY()==65 || getY()==66) && (getX()>=91 && getX()<=279)) || ((getY()==145 || getY()== 146) && (getX()>=91 && getX()<=279)) || (getY()==199 || getY()== 200) || (getY()==280 || getY()== 281) || ((getY()==335 || getY()==336) && (getX()>=91 && getX()<=279)) || ((getY()==415 || getY()==416) && (getX()>=91 && getX()<=279)) || (getY()==470 || getY()== 471) || ((getY()==90 || getY()==91) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) || ((getY()==390 || getY()==391) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) )
        {
            
            if(x < pac.getX())
                 xdir = 1*speed;    
             else xdir = -1*speed; 
            
            if(getY() == 11 || getY() == 66 || getY() == 91 || getY() == 146 || getY() == 200 || getY() == 281 || getY() == 336 || getY() == 391 || getY()== 416 || getY() == 471)
            {
             y = y - 1;
             }
            
        }
    }
      
      else if(randomdirection == 2)
        {
         if((getX()==10 || getX() == 11) || ((getX()==117 || getX()==118) && (getY()>=199 && getY()<=280)) || ((getX()==253 || getX()== 254) && (getY()>=199 && getY()<=280)) || ((getX()==91 || getX()== 92) && ((getY()>=10 && getY()<= 199) || (getY()>=280 && getY()<=470))) || (getX()==360 || getX()==361) || ((getX()==279 || getX()==280) && ((getY()>=10 && getY()<=199) || (getY()>=280 && getY()<=470))) )
       {
         if(y < pac.getY())
                 ydir = 1*speed;    
             else ydir = -1*speed; 
            
           if(getX() == 11 || getX() == 92 || getX() == 118 || getX() == 186 || getX() == 254 || getX() == 280 || getX() == 361)
          {
              x = x - 1;
             }
            
       }
    }
   
     else
     {  changeDirectionRandom();
      }
    
   }
   public void changeDirectionRandom()
    {
         if ( (getX() == 10 || getX()== 91 || getX()==117+1/2 || getX()==185 || getX()==253 || getX() == 279 || getX()== 360) && (getY() == 10 || getY() == 65 || getY() == 90 || getY()== 145 || getY()== 199 || getY()== 280 || getY()== 335 || getY()==390 || getY()==415 || getY()==470 ))
       {
           int randomdirection = (int)(Math.random() *4+1);
           if ( (getX()==91 && getY()==65) || (getX()==279 && getY()==65) || (getX()==10 && getY()==90) || (getX()==91 && getY()==90) || (getX()==279 && getY()==90) || (getX()==360 && getY()==90) || (getX()==91 && getY()==145) || (getX()==279 && getY()==145) || (getX()==10 && getY()==199) || (getX()==91 && getY()==199) || (getX()==279 && getY()==199) || (getX()==360 && getY()==199) || (getX()==10 && getY()==280) || (getX()==360 && getY()==280) || (getX()==91 && getY()==335) || (getX()==279 && getY()==335) || (getX()==10 && getY()==390) || (getX()==91 && getY()==390) || (getX()==279 && getY()==390) || (getX()==360 && getY()==390) || (getX()==91 && getY()==415) || (getX()==279 && getY()==415) || (getX()==10 && getY()==470) || (getX()==91 && getY()==470) || (getX()==279 && getY()==470)||(getX()==360 && getY()==470) ||(getX()==117+1/2 && getY()==280) || (getX()==253 && getY()==280) )
          {
           if(randomdirection==1) 
            {
              xdir =  0;
              ydir = -1*speed;
             }
            }
            if ( (getX()==10 && getY()==10) || (getX()==91 && getY()==10) || (getX()==279 && getY()==10) || (getX()==360 && getY()==10) || (getX()==91 && getY()==65) || (getX()==279 && getY()==65) || (getX()==10 && getY()==90) || (getX()==91 && getY()==90) || (getX()==279 && getY()==90) || (getX()==360 && getY()==90) || (getX()==91 && getY()==145) || (getX()==279 && getY()==145) || (getX()==10 && getY()==199) || (getX()==360 && getY()==199) || (getX()==10 && getY()==280) || (getX()==91 && getY()==280) || (getX()==279 && getY()==280) || (getX()==360 && getY()==280) || (getX()==91 && getY()==335) || (getX()==279 && getY()==335) || (getX()==10 && getY()==390) || (getX()==91 && getY()==390) || (getX()==279 && getY()==390) || (getX()==360 && getY()==390) || (getX()==91 && getY()==415) || (getX()==279 && getY()==415) || (getX()==117+1/2 && getY()==199) || (getX()==253 && getY()==199) )
          {
           if(randomdirection==2)    
            {
              xdir =  0;
              ydir = 1*speed;
             }
            }
            if ((getX()==91 && getY()==10) || (getX()==279 && getY()==10) || (getX()==360 && getY()==10)|| (getX()==279 && getY()==65)|| (getX()==91 && getY()==90)||(getX()==360 && getY()==90)|| (getX()==279 && getY()==145) || (getX()==91 && getY()==199) || (getX()==279 && getY()==199)|| (getX()==360 && getY()==199)||(getX()==91 && getY()==280)||(getX()==279 && getY()==280)||(getX()==360 && getY()==280)||(getX()==279 && getY()==335)||(getX()==91 && getY()==390)||(getX()==360 && getY()==390)||(getX()==279 && getY()==415)||(getX()==91 && getY()==470)||(getX()==279 && getY()==470)||(getX()==360 && getY()==470)||(getX()==117+1/2 && getY()==199) || (getX()==253 && getY()==199)||(getX()==117+1/2 && getY()==280) || (getX()==253 && getY()==280) || (getX()==185 && getY()==145)  )
           {
          if(randomdirection==3)    
            {
              xdir = -1*speed;
              ydir =   0;
             }
            }
            if ( (getX()==10 && getY()==10) || (getX()==91 && getY()==10) || (getX()==279 && getY()==10) || (getX()==91 && getY()==65) || (getX()==10 && getY()==90) || (getX()==279 && getY()==90) || (getX()==91 && getY()==145) || (getX()==10 && getY()==199) || (getX()==91 && getY()==199) || (getX()==279 && getY()==199) || (getX()==10 && getY()==280)||(getX()==91 && getY()==280)||(getX()==279 && getY()==280)||(getX()==91 && getY()==335)||(getX()==10 && getY()==390)||(getX()==279 && getY()==390)||(getX()==91 && getY()==415)||(getX()==10 && getY()==470)||(getX()==91 && getY()==470)||(getX()==279 && getY()==470)||(getX()==117+1/2 && getY()==199) || (getX()==253 && getY()==199)||(getX()==117+1/2 && getY()==280) || (getX()==253 && getY()==280)|| (getX()==185 && getY()==145) )
          {
           if(randomdirection==4)    
            {
              xdir = 1*speed;
              ydir =  0;
             } 
            } 
        
 
    }    
} 
     public void changeDirectionRun(Pacman4 pac)
    {
        xdir = 0; 
        ydir = 0; 
        
        randomdirection = (int)(Math.random()  * 2 + 1);
        if(randomdirection == 1)
        {
           if((getY()==10 || getY() == 11) || ((getY()==65 || getY()==66) && (getX()>=91 && getX()<=279)) || ((getY()==145 || getY()== 146) && (getX()>=91 && getX()<=279)) || (getY()==199 || getY()== 200) || (getY()==280 || getY()== 281) || ((getY()==335 || getY()==336) && (getX()>=91 && getX()<=279)) || ((getY()==415 || getY()==416) && (getX()>=91 && getX()<=279)) || (getY()==470 || getY()== 471) || ((getY()==90 || getY()==91) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) || ((getY()==390 || getY()==391) &&((getX()>=10 && getX()<=91) || (getX()>=279 && getX()<=360))) )
        {
        
            if(x < pac.getX())
                 xdir = -1*speed;    
             else xdir = 1*speed;     
        
         if(getY() == 11 || getY() == 66 || getY() == 91 || getY() == 146 || getY() == 200 || getY() == 281 || getY() == 336 || getY() == 391 || getY()== 416 || getY() == 471)
         {
             y = y - 1;
             }
        }
      }
        if(randomdirection == 2)
        {
         if((getX()==10 || getX() == 11) || ((getX()==117 || getX()==118) && (getY()>=199 && getY()<=280)) || ((getX()==253 || getX()== 254) && (getY()>=199 && getY()<=280)) || ((getX()==91 || getX()== 92) && ((getY()>=10 && getY()<= 199) || (getY()>=280 && getY()<=470))) || (getX()==360 || getX()==361) || ((getX()==279 || getX()==280) && ((getY()>=10 && getY()<=199) || (getY()>=280 && getY()<=470))) )
       {
         
         
          if(y < pac.getY())
                 ydir = -1*speed;    
             else ydir = 1*speed;    
        
         if(getX() == 11 || getX() == 92 || getX() == 118 || getX() == 186 || getX() == 254 || getX() == 280 || getX() == 361)
          {
              x = x - 1;
             }
        
       }
      }
    
   
  
    }
    public void setLocation(int xx, int yy)
    {
        x = xx;
        y = yy;
    }
          
    public void increaseSpeed()
    {
      speed = speed + 0.2;    
    }
}