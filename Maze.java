import java.util.*;
import java.io.*;

public class Maze{

  private char[][] maze;
  private boolean animate; //false by default
  public static int rows, xStart, yStart;

  /*Constructor loads a maze text file, and sets animate to false by default.
     When the file is not found then:
        throw a FileNotFoundException

     You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
     '#' - Walls - locations that cannot be moved onto
     ' ' - Empty Space - locations that can be moved onto
     'E' - the location of the goal (exactly 1 per file)
     'S' - the location of the start(exactly 1 per file)

     You ma also assume the maze has a border of '#' around the edges.
     So you don't have to check for out of bounds!
   */

  public Maze(String filename) throws FileNotFoundException{

    try {
      File text = new File(filename);
      Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
          String line = inf.nextLine();
          rows += 1;
        }

        maze = new char[rows][];
        rows = 0;

      File text1 = new File(filename);
      Scanner inf1 = new Scanner(text1);

        while(inf1.hasNextLine()){
          String next = inf1.nextLine();
          maze[rows] = next.toCharArray();
          rows += 1;
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

    /*Wrapper Solve Function returns the helper function
     Note the helper function has the same name, but different parameters.
     Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
   */
   public int solve(){
    //find the location of the S.
      for (int i = 0; i < maze.length; i++){
        for (int j = 0; j < maze[0].length; j++){
          if (maze[i][j] == 'S'){
            xStart = i;
            yStart = j;
          }
        }
      }

    //erase the S.
      maze[xStart][yStart] = ' ';

    //and start solving at the location of the s.
    //return solve(???,???);
      return (solve(xStart, yStart, 0));
   }


    /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
    The S is replaced with '@' but the 'E' is not.
    All visited spots that were not part of the solution are changed to '.'
    All visited spots that are part of the solution are changed to '@'
    */


    private int solve(int row, int col, int counter){

    //automatic animation! You are welcome.

    if(animate){
      clearTerminal();
      System.out.println(this);
      wait(20);
    }


    //What happens if the space on the maze isn't empty? You try a different direction!
    if (maze[row][col] == '#' ||
        maze[row][col] == '.' ||
        maze[row][col] == '@'){
        return 0;

    //What happens if the space on the maze is empty? Assigns it to '@' for now.
    } else if (maze[row][col] == ' '){
        maze[row][col] = '@';

    //What happens if you found the solution? Returns the # of '@'s?
    } else if (maze[row][col] == 'E'){
        return counter;
    }

    //Checks the right.
    int right = solve(row, col+1, counter+1);
    if (right > 0){
      return right;
    }

    //Checks the left.
    int left = solve(row, col-1, counter+1);
    if (left > 0){
      return left;
    }

    //Checks upwards.
    int up = solve(row+1, col, counter+1);
    if (up > 0){
      return up;
    }

    //Checks downwards.
    int down = solve(row-1, col, counter+1);
    if (down > 0){
      return down;
    }

    //Backtracking?
      maze[row][col] = '.';
      return -1;
  }

  //Testing purposes.
  public static void main(String[] args) throws FileNotFoundException {
    Maze test;
    test = new Maze("data1.dat");
    test.solve();
    System.out.println(test);
  }

}
