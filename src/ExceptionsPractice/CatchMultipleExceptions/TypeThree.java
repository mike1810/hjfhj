package ExceptionsPractice.CatchMultipleExceptions;

public class TypeThree extends Exception {

    private String message;

    TypeThree(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
