package task3;

import static java.lang.System.*;
import static java.lang.Math.*;
import java.util.Scanner;

public class task3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(in);

        out.println("Input array size");
        int arr_size = scan.nextInt();

        int array[] = new int[arr_size];

        //selection sort
        array_fill(array);// fill array
        print_arr(array);// show array
        selection_sort(array);// doing selection sort
        print_arr(array);// show array after selection sorting

        //insertion sort
        array_fill(array);// fill array again
        print_arr(array);// show array
        insertion_sort(array);// doing insertion sort
        print_arr(array);// show array after insertion sorting

    }

    static void array_fill(int... array){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(random()*1000);
        }
    }

    static void insertion_sort(int... array)
    {
        int size = array.length;
        int temp, x;
        for (int i = 1;i < size;i++)
        {
            x = array[i];
            int j = i;
            while (j > 0 && array[j-1] > array[j])
            {
                temp=array[j];
                array[j] = array[j-1];
                array[j-1]=temp;
                j --;
            }
            array[j] = x;
        }
    }
    static void print_arr(int... array){
        for(int a : array){
            out.print(a + " ");
        }
        out.println();
    }

    static void selection_sort(int... arr) {
        for (int min = 0; min < arr.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[least]) {
                    least = j;
                }
            }
            int tmp = arr[min];
            arr[min] = arr[least];
            arr[least] = tmp;
        }
    }
}