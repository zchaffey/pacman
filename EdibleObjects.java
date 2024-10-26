
public class EdibleObjects extends GameObject
{
    boolean eaten;
    public EdibleObjects(int xx, int yy)
    {
       super(xx,yy);
       eaten = false;
    }

     public boolean getEaten()
    {
        return eaten;
    }
    
    public void setEaten(boolean e)
    {
        eaten = e;
    }

    
    public void EatIt()
    {
       eaten = true;
    }
    
    
}
