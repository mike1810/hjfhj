package task4;

import static java.lang.System.*;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        char searched;
        searched = scan.next().charAt(0);

        out.println(searched);

        String text = "Have i got searched symbol?";
        out.println(text);

        int check = 0;
        for(char ch : text.toCharArray())
        {
            if(searched == ch){
                check++;
            }
        }
        out.println((check == 0)?("You have not got"):("You have got symbol '" + searched + "' " + check + " times"));
    }

}