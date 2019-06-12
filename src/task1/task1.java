package task1;
import static java.lang.System.*;


public class task1 {

    static int lowest;
    public static void main(String[] args) {
        // write your code here
        int arr4 [] = {6,5,4,3};

        out.printf("Array has a lowest: %d\n", lowest_of_arr2(arr4));
        out.printf("Array has a lowest: %d\n", lowest_of_arr3(arr4));
        out.printf("Array has a lowest: %d\n", lowest_of_arr4(arr4));

    }
    static int lowest_of_arr2(int... arr){
        return lowest = (arr[0] < arr[1]) ? arr[0] : arr[1];
    }
    static int lowest_of_arr3(int... arr){
        int of_2 = lowest_of_arr2(arr);
        return lowest = (of_2 < arr[2]) ? of_2 : arr[2];
    }
    static int lowest_of_arr4(int... arr){
        int of_3 = lowest_of_arr3(arr);
        return lowest = (of_3 < arr[3]) ? of_3 : arr[3];
    }
}
