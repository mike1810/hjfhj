package ExceptionsPractice.ExceptionsHierarchy;

public class HierarchyC extends HierarchyB {

    private String message;

    HierarchyC(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}