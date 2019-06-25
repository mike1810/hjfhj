package GenericsTheSecond;

public class GenericMethod{

    public static <T extends Comparable> boolean compareTo(T comparedTo, T comparedWith){
        if(comparedTo == null || comparedWith == null){
            return false;
        }
        if(comparedTo.getClass() != comparedWith.getClass()){
            return false;
        }
        return comparedTo.compareTo(comparedWith) == 0;
    }
}