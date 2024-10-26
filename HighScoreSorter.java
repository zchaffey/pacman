
/**
 * Write a description of class HighScoreSorter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;

public class HighScoreSorter
{
   
    public HighScoreSorter()
    {
        
    }
    public static HighScore[] HighScoreS(HighScore[] highscores,int newhighscore,String name,JFrame f1,ImageIcon icon)
    {
      int index=5;
      while ((index>0)&&(newhighscore > highscores[index-1].getHighScore()) )
      {
          index--;
      }
      if (index<5)
      {
      name = (String)JOptionPane.showInputDialog(f1,"You have the new high score of: "+newhighscore+ "\n Enter Your name","High Score Entry",JOptionPane.INFORMATION_MESSAGE,icon,null,"");
      int highscorepos=index;
      if (highscorepos == 3)
      index++;
      if (highscorepos == 2)
      index = index +2;
      if (highscorepos ==1)
      index=index + 3;
      if (highscorepos ==0)
      index = index +4;
      while ((index<5)&&(index > highscorepos))
      {
          highscores[index] = highscores[index-1];
          index--;
        }
    
      if (highscorepos==0)
           highscores[0]=new HighScore(name,newhighscore);
      if (highscorepos==1)
           highscores[1]=new HighScore(name,newhighscore);
      if (highscorepos==2)
           highscores[2]=new HighScore(name,newhighscore);
      if (highscorepos==3)
           highscores[3]=new HighScore(name,newhighscore);
      if (highscorepos==4)
           highscores[4]=new HighScore(name,newhighscore);
    }
      return highscores;
    }
}
