package task1;
import static java.lang.System.*;


public class task1 {

    static int lowest;
    public static void main(String[] args) {
        // write your code here
        int arr4 [] = {6,5,4,3};

        out.printf("Array has a lowest: %d\n", lowest_of_arr(arr4[0], arr4[1]));
        out.printf("Array has a lowest: %d\n", lowest_of_arr(arr4[0], arr4[1], arr4[2]));
        out.printf("Array has a lowest: %d\n", lowest_of_arr(arr4[0], arr4[1], arr4[2], arr4[3]));
    }

    static int lowest_of_arr(int x, int y){
        return lowest = (x < y) ? x : y;
    }
    static int lowest_of_arr(int x, int y, int z){
        int of_2 = lowest_of_arr(x,y);
        return lowest = (of_2 < z) ? of_2 : z;
    }
    static int lowest_of_arr(int x, int y, int z, int u){
        int of_3 = lowest_of_arr(x,y,z);
        return lowest = (of_3 < u) ? of_3 : u;
    }
}
