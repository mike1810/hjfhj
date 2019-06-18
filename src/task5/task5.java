package task5;
import static java.lang.System.*;
import java.util.Scanner;
public class task5 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        int N;
        boolean check = true;
        do {
            out.print((check)? "Enter number of disks: " : "Number of disks can`t be less than 0. Enter it again: ");
            N = scan.nextInt();
            check = false;
        }
        while(N <=0);

        out.println("\nWe need replace '" + N + "' disks from A to C in " + ((int)Math.pow(2.0, N)-1) + " steps");
        Towers(N, "A", "C", "B");
        out.println("\nWe replaced '" + N + "' disks from A to C in " + count + " steps");
    }
    static void Towers(int number, String a, String c, String b)
    {
        if(number!=0)
        {
            Towers(number-1, a, b, c);

            count++;
            out.println("\n  Step " + count + ": take off disk " + number + " from stick " + a + " and put on to stick " + c);

            Towers(number-1,  b, c, a);
        }
    }
}