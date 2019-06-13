package task4;

import static java.lang.System.*;
import java.util.Scanner;

public class task4{

    public static void main(String[] args) {
        Scanner scan = new Scanner(in);
        String key;
        boolean check = false;
        do{
            out.println((check)?("It`s a string, please enter only one symbol you need to find:"):("Enter only one symbol you need to find:"));
            check = true;
            key = scan.next();
        }
        while(key.length() > 1 || key.length() < 0);

        String text = "Have this text got searched symbol?";
        find_key(text, key);
    }

    static void find_key(String text, String key){
        out.println("Your symbol is '" + key + "'");
        out.println(text);
        int count = 0;
        for(char a : text.toCharArray())
        {
            for(char b : key.toCharArray())
            {
                if(a==b){
                    count++;
                }
            }
        }
        out.println((count == 0)?("You have not got"):("You have got symbol '" + key + "' " + count + " times"));
    }
}