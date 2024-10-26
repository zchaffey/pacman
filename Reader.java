
/**
 * Write a description of class Reader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class Reader
{
    
    public Reader()
    {
    }
    public static HighScore[] readfile()
    {
          File thefile = new File("TheSaveHighscoreFile.txt");
          HighScore[] highscores=new HighScore[5];
          try
             {
                 FileReader freader = new FileReader(thefile);
                 BufferedReader breader = new BufferedReader(freader);
                 
                for (int index=0; index<5; index++)
                {
                String name = breader.readLine();  
                String[] tokens = name.split(" ");
                name = tokens[0];
                String score = tokens[1];
                int highscore = Integer.parseInt(score);
                HighScore hs= new HighScore(name,highscore);
                highscores[index]=hs;
                
               }
                 breader.close();
                
                               
             }
             catch(IOException ex) 
               {
                  HighScore hs = new HighScore("", 0);
                }
                return highscores;
    }

}
