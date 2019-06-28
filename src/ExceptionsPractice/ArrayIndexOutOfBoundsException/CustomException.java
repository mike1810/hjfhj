package ExceptionsPractice.ArrayIndexOutOfBoundsException;

public class CustomException extends Exception {

    public static void main(String[] args){
        try{
            throw new CustomException("Exercised my CustomException");
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }

    String message;
    CustomException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
