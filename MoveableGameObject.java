
public class MoveableGameObject extends GameObject
{
    double xdir,ydir,speed;
    public MoveableGameObject(int xx, int yy)
    {
       super(xx,yy);
    }

   public void moveIt()
   {
       x = x + xdir;
       y = y + ydir;
    }   
}
