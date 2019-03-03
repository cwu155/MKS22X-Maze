import java.util.*;
import java.io.*;

public class Maze{

  private char[][] maze;
  private boolean animate; //false by default
  private int rows, numCols, counter;

  public Maze(String filename) throws FileNotFoundException{

    try {
      File text = new File(filename);
      Scanner inf = new Scanner(text);

      while(inf.hasNextLine()){
        String line = inf.nextLine();
        counter += 1;
      }

      maze = new char[counter][];
      counter = 0;

      File text1 = new File(filename);
      Scanner inf1 = new Scanner(text1);

      while(inf1.hasNextLine()){
        String next = inf1.nextLine();
        maze[counter] = next.toCharArray();
        counter += 1;
      }

    } catch (FileNotFoundException ex){
      System.out.println("Yikes");
    }
  }

  //Wait method.
  private void wait(int millis){
      try {
        Thread.sleep(millis);
      } catch (InterruptedException e) {
      }
  }

  //Animate method.
  public void setAnimate(boolean b){
      animate = b;
  }

  //ClearTerminal method. Erase terminal, go to top left of screen.
  public void clearTerminal(){
      System.out.println("\033[2J\033[1;1H");
  }

  /*Return the string that represents the maze.
     It should look like the text file with some characters replaced.
    */
    public String toString(){
    String result = "";
      for (int i = 0; i < maze.length; i++){
        for (int j = 0; j < maze[0].length; j++){
          result += maze[i][j];
        }
        result += '\n';
      }
      return result;
    }



public static void main(String[] args) throws FileNotFoundException{
    Maze test;
    test = new Maze("data1.dat");
    System.out.println(test);
    }

  }
