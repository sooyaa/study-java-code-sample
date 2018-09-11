import java.io.PrintStream;
import java.io.IOException;
import java.io.File;

import java.util.Random;

public class WriteToFile {

    public static void main(String[] args){

        try{
            PrintStream write = new PrintStream( new File("randInts.txt"));
            Random r = new Random();
            final int LIMIT = 100;

            for( int i=0; i<LIMIT; i++){
                write.println( r.nextInt() );
            }
            write.close();
        }
        catch(IOException e){
            System.out.println("An error occured while trying to write to the file");
        }
    }
}
