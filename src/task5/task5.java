package task5;
import static java.lang.System.*;
import java.util.Scanner;
public class task5 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        out.print("Enter number of disks: ");
        int N = scan.nextInt();

        out.println("We need replace '" + N + "' disks from A to C in " + ((int)Math.pow(2.0, N)-1) + " steps");
        Towers(N, 1, 3, 2);
        out.println("We replaced '" + N + "' disks from A to C in " + count + " steps");
    }
    static void Towers(int number, int from, int to, int free)
    {
        if(number!=0)
        {
            Towers(number-1, from, free, to);

            count++;
            out.println("\n  Step " + count + ": take off disk " + number + " from stick " + from + " and put on to stick " + to);

            Towers(number-1,  free, to, from);

        }
    }
}
