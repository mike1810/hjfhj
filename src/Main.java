import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(in);

        out.println("Input array size");
        int arr_size = scan.nextInt();
        out.println("Input searched number");
        int searched = scan.nextInt();

        int array[] = new int[arr_size];

        for(int i = 0; i < array.length; i++){
            array[i] = (int)(random()*10);
        }
        print_arr(array);

        // one by one
        boolean searched_in = one_by_one_search(searched, array);
        if(searched_in)
            out.println("true");
        else{
            out.println("false");
        }

        //binary
        Arrays.sort(array);
        print_arr(array);
        searched_in = false;
        searched_in = binary_search(searched, array);
        if(searched_in)
            out.println("true");
        else{
            out.println("false");
        }
    }

    static void print_arr(int... array){
        for(int a : array){
            out.print(a + " ");
        }
    }
    static boolean one_by_one_search(int searched,int... array){
        boolean in = false;
        for(int a : array){
            if(a == searched){
                in = true;
                break;
            }
        }
        return in;
    }
/////////////////////////////////////////////////////////////////////////////
    static boolean binary_search(int searched,int... array){
        boolean in = false;
        int min_index = 0, max_index = array.length - 1;
        int compared_with = (min_index+max_index)/2;

        do {
            if (array[compared_with] < searched) {

                min_index = compared_with;
                compared_with = (min_index+max_index)/2;
            }
            else{
                if (array[compared_with] > searched) {
                    max_index = compared_with;
                    compared_with = (min_index+max_index)/2;
                }
                else{
                    return in;
                }

            }
        }
        while((max_index - min_index) >= 0);
        return in;
    }
/////////////////////////////////////////////////////////////////////////////

}