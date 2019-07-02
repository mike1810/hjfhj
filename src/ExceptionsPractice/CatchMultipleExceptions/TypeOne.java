package ExceptionsPractice.CatchMultipleExceptions;

public class TypeOne extends Exception {

    private String message;

    TypeOne(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
