import java.util.*;
import java.io.*;

public class Maze{

  private char[][] maze;
  private char[] columns;
  private boolean animate; //false by default
  private int rows, cols;

  public Maze(String filename) throws FileNotFoundException{
      rows = 0;
      File text = new File(filename);

      //inf stands for the input file
      Scanner inf = new Scanner(text);

      while(inf.hasNextLine()){
          String line = inf.nextLine();
          rows += 1;

          if (rows == 1){
               columns = line.toCharArray();
          }
         }

       }
  }
