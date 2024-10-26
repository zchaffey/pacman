

public class SpaceShip
{
     int x, y, score; 
     
    public SpaceShip(int xx, int yy)
    {
        x = xx;
        y = yy; 
        score = 0;
    }
    public void setShiploc(int xx, int yy)
     {
       x = xx;
       y = yy;
        
      }

    public int getX()
    {
      return x;    
    }
    
    public int getY()
    {
      return y;    
    }
    
    public int getScore()
    {
      return score;    
    }
    
    public void addScore(int points)
   {
      score = score + points;   
    } 
    
    public void moveShip(int xdir, int ydir)
    {
       x = x + xdir;
       y = y + ydir;
    }
}
