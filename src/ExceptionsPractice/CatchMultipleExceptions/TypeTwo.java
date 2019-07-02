package ExceptionsPractice.CatchMultipleExceptions;

public class TypeTwo extends Exception {

    private String message;

    TypeTwo(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
