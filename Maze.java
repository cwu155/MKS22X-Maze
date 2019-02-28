import java.util.*;
import java.io.*;

public class Maze{

  private char[][] maze;
  private char[] columns;
  private boolean animate; //false by default
  private int rows, cols;

  public Maze(String filename) throws FileNotFoundException{

      try {
      rows = 0;
      File text = new File(filename);
      Scanner inf = new Scanner(text);

      while(inf.hasNextLine()){
          String line = inf.nextLine();
          rows += 1;

          if (rows == 1){
               columns = line.toCharArray();
               cols = columns.length;
          }
        }

        char[][] maze = new char[rows][cols];

      } catch (FileNotFoundException ex){
        System.out.println("Yikes");
      }

    }

    private void wait(int millis){
           try {
               Thread.sleep(millis);
           }
           catch (InterruptedException e) {
           }
       }

      public void setAnimate(boolean b){
          animate = b;
      }

      public void clearTerminal(){
          //erase terminal, go to top left of screen.
          System.out.println("\033[2J\033[1;1H");
      }


    public static void main(String[] args) throws FileNotFoundException{
      Maze a = new Maze("Maze1.txt");
      System.out.println(a);
    }
  }
