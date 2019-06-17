package task2;

import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Arrays;
import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(in);

        int arr_size;
        boolean check = true;
        do {
            out.println((check)?"Input array size(above 0):":("Input array size again, last value is not above 0:"));
            arr_size = scan.nextInt();
            check = false;
        }
        while(arr_size<=0);

        check = true; int N = 1000000;
        int searched;
        do {
            out.println((check)?("Input searched number (which in [0;" + N + "]):"):("Input searched number  again, last value is not correct"));
            searched = scan.nextInt();
        }
        while(searched > N || searched < 0);

        int[] array = new int[arr_size];

        for(int i = 0; i < array.length; i++){
            array[i] = (int)(random()*N);
        }

        out.println("if u need to see arrays later, press '1', or something else if not ");

        boolean need_to_see;// need to call print_arr();
        String s_need_to_see = scan.next();
        switch(s_need_to_see){
            case "1": need_to_see = true; break;
            default: need_to_see = false; break;
        }

        long startTime, finishTime, executionTime;// need to check execution

        // one by one
        out.println("\nOne by one search started");
        if(need_to_see){
            print_arr(array);
        }
        startTime = System.nanoTime();
        boolean searched_in = one_by_one_search(searched, array);//one by one search
        finishTime = System.nanoTime();
        executionTime = finishTime - startTime;
        print_result(searched_in, searched);//show result
        out.println("One by one search finished in " + executionTime + " nanoseconds");

        //binary
        Arrays.sort(array);//array sorting
        if(need_to_see) {
            print_arr(array);
        }
        out.println("\nBinary search started");
        startTime = System.nanoTime();
        searched_in = binary_search(searched, array);
        finishTime = System.nanoTime();
        executionTime = finishTime - startTime;
        print_result(searched_in, searched);
        out.println("Binary search finished in " + executionTime + " nanoseconds");
    }

    static void print_result( boolean searched_in, int searched){
        out.println((searched_in)?("Number " + searched +  " is in array"):("Number " + searched +  " is not in array"));
    }

    static void print_arr(int... array){

        out.println("\nYour array:");
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
    static boolean binary_search(int key,int... array){
        boolean in = false;
        int min_index = 0, max_index = array.length - 1;
        int compared_with;

        while(max_index > min_index){

            compared_with = (min_index+max_index)/2;
            if(max_index - min_index == 2 && array[min_index+1] == key){
                    in = true;
                    return in;
            }

            if(array[compared_with] == key){
                in = true;
                return in;
            }
            else{
                if(array[compared_with] < key){
                    min_index = compared_with + 1;
                }
                else{
                    max_index = compared_with - 1;
                }
            }
        }
        return in;
    }
}