import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void main(String args[]){

    //Printing maze directly from the file.
      // try {
      //   File text = new File("Maze1.txt");
      //
      //   //inf stands for the input file
      //   Scanner inf = new Scanner(text);
      //
      //   while(inf.hasNextLine()){
      //       String line = inf.nextLine();
      //       System.out.println(line);//hopefully you can do other things with the line
      //   }
      //
      // } catch (FileNotFoundException e){
      // System.out.println("File not found!!");
      // }

    //Printing maze using an array.
   int rows = 0;
      try {
        File text = new File("Maze1.txt");

        //inf stands for the input file
        Scanner inf = new Scanner(text);

        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);

            rows += 1;
        }

      } catch (FileNotFoundException e){
      System.out.println("File not found!!");
      }

      System.out.println(rows);

    }
  }
