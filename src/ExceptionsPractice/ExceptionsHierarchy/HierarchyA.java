package ExceptionsPractice.ExceptionsHierarchy;

public class HierarchyA extends Throwable {

    private String message;

    HierarchyA(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}