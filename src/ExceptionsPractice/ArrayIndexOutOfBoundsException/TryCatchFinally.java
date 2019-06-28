package ExceptionsPractice.ArrayIndexOutOfBoundsException;

public class TryCatchFinally {
    public static void main(String[] args){
        try{
            throw new Exception("Exception in 'try'");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Finally, you can see this text in the console window");
        }
    }
}