package task2;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class task2 {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(in);


        out.println("If u need to see, how binary search better then one-by-ine, u can input array size = 1000000 and searched number = 1000001");

        out.println("Input array size");
        int arr_size = scan.nextInt();
        out.println("Input searched number");
        int searched = scan.nextInt();

        int array[] = new int[arr_size];

        for(int i = 0; i < array.length; i++){
            array[i] = (int)(random()*1000);
        }
        //if u need to see array numbers, uncomment next line
        //print_arr(array);

        long startTime, finishTime, executionTime;// need to check execution

        // one by one
        out.println("One by one search started");
        startTime = System.nanoTime();
        boolean searched_in = one_by_one_search(searched, array);//one by one search
        finishTime = System.nanoTime();
        executionTime = finishTime - startTime;
        print_result(searched_in, searched);//show result
        out.println("One by one search finished in " + executionTime + " nanoseconds");

        //binary
         out.println("Binary search start");
        Arrays.sort(array);//array sorting
        //if u need to see array numbers, uncomment next line
        //print_arr(array);
        startTime = System.nanoTime();
        searched_in = binary_search(searched, array);
        finishTime = System.nanoTime();
        executionTime = finishTime - startTime;
        print_result(searched_in, searched);
        out.println("Binary search finished in " + executionTime + " nanoseconds");
    }

    static void print_result( boolean searched_in, int searched){

        if(searched_in)
            out.println("Number " + searched +  " is in array");
        else{
            out.println("Number " + searched +  " is not in array");
        }
    }

    static void print_arr(int... array){
        for(int a : array){
            out.print(a + " ");
        }
        out.println();
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
    static boolean binary_search(int key,int... array){
        boolean in = false;
        int min_index = 0, max_index = array.length - 1;
        int compared_with;

        while(max_index > min_index){
            compared_with = (min_index+max_index)/2;
            if (array[compared_with] < key) {

                min_index = compared_with + 1;
            }
            else{
                if (array[compared_with] > key) {
                    max_index = compared_with - 1;
                    compared_with = (min_index+max_index)/2;
                }
                else{
                    in = true;
                    return in;
                }
            }
        }
        return in;
    }
/////////////////////////////////////////////////////////////////////////////
}