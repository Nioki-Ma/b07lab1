import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String [] args) throws IOException 
    {
        // this  1x3 + 2x2 + x ----[1,2,1] and [3,2,1]
        // other 1x2 + 1x0     ----[1,1]   and [2,0]

        double[] coe1 = {1,2,1};
        int[]    exp1 = {3,2,1};
        Polynomial p1 = new Polynomial(coe1, exp1);

        double[] coe2 = {1,1};
        int[]    exp2 = {2,0};
        Polynomial p2 = new Polynomial(coe2, exp2);

        System.out.println("Check Add p2 to p1");
        Polynomial res1 = p1.add(p2);
        System.out.println(res1);

        System.out.println("Check Multiply p2 with p1");
        Polynomial res2 = p1.multiply(p2);
        System.out.println(res2);

        try
         {
            File file = new File("original_data.txt");
            Polynomial p3 = new Polynomial(file);

            System.out.println(p3);

            p1.saveToFile("new_data.txt");

        } 
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException(e);
        }
    }
}