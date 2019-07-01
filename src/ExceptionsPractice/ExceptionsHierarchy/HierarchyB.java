package ExceptionsPractice.ExceptionsHierarchy;

public class HierarchyB extends HierarchyA {

    private String message;

    HierarchyB(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}