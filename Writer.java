
/**
 * Write a description of class Writer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class Writer
{
 
   
    public Writer()
    {
    }
    public static void writefile(HighScore[] highscores)
    {
        File thefile=new File("TheSaveHighscoreFile.txt");
       
        try
             {
                 FileWriter fwriter = new FileWriter(thefile);
                 BufferedWriter bwriter = new BufferedWriter(fwriter);
                 
                 for (int index=0; index<5; index++)
                 {
                 bwriter.write(highscores[index].getName()+" "+highscores[index].getHighScore());
                 bwriter.newLine();
                }
                

                 bwriter.close();
             }
             catch(IOException ex) {}
    }
}
