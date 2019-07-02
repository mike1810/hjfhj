package ExceptionsPractice.CustomException;

public class CustomExceptionTest {
    public static void main(String[] args){
        try{
            throw new CustomException("CustomException exercised");
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
}
