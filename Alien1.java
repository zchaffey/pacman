

public class Alien1
{
     int x, y;
     boolean destroyed;
     
    public Alien1(int xx, int yy)
    {
      x = xx;
      y = yy;
      destroyed = false;
    }
    
    
    public int getX()
    {
        return x;
    }
    
    
    public int getY()
    {
        return y;
    }
    
    
    public boolean getDestroyed()
    {
        return destroyed;
    }

    
    public void destroyAlien()
    {
       destroyed = true;
    }
    
    
    

    
}
