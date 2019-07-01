package ExceptionsPractice.ExceptionsHierarchy;

public class Demo {
    public static void main(String[] args) {
        try {
            throw (HierarchyA) new HierarchyC("C");
        } catch (HierarchyA e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}