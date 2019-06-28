package ExceptionsPractice.ArrayIndexOutOfBoundsException;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5};

        try{
            System.out.println(array[6]);
        }catch(java.lang.ArrayIndexOutOfBoundsException ex){
            System.out.println("Exception 'ArrayIndexOutOfBoundsException' generated");
        }
    }



}