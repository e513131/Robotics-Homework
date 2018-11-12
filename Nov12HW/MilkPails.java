//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("pails.in"));
        FileWriter fw = new FileWriter("pails.out");

        int small = s.nextInt();
        int medium = s.nextInt();
        int large = s.nextInt();

        int output = howFull(small, medium, large);

        fw.write(Integer.toString(output));
        fw.flush();

        s.close();
        fw.close();


        // int small=26;
        // int medium=646;
        // int large=947;

        // System.out.println(howFull(small, medium, large));
    }

    static int howFull(int small, int medium, int large){
        //equation in the form of ax+by=z: a is "small," b is "medium," and c is "small"
        int aMax=large/small;
        int bMax=large/medium;

        int max = 0;

        for(int i=0; i<=aMax; i++){
            for(int j=0; j<=bMax; j++){
                if(i*small+j*medium==large){   
                    return large;
                }
                else if(i*small+j*medium > max && i*small+j*medium < large){
                    //System.out.println(i*small+j*medium);
                    max=(i*small+j*medium);
                }
            }
            
        }
        return max;
    }   
}