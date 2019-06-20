package inheritanceAndPolymorphismPracticeTheThird;

public class MathWithVarargs {
    public static int min(int... intArray){
        int min = intArray[0];
        for(int value : intArray){
            if(value < min)
                min = value;
        }
        return min;
    }

    public static double min(double... intArray){
        double min = intArray[0];
        for(double value : intArray){
            if(value < min)
                min = value;
        }
        return min;
    }

    public static int max(int... intArray){
        int min = intArray[0];
        for(int value : intArray){
            if(value > min)
                min = value;
        }
        return min;
    }

    public static double max(double... intArray){
        double min = intArray[0];
        for(double value : intArray){
            if(value > min)
                min = value;
        }
        return min;
    }

    public static int nextAfter(int This, int... inIntArray){
        int maxInIntArray = max(inIntArray);
        if(maxInIntArray <= This){ return 0; }
        int minNextAfterThis = maxInIntArray;
        for(int value : inIntArray){
            if(value > This & value < minNextAfterThis)
                minNextAfterThis = value;
        }
        return minNextAfterThis;
    }

    public static double nextAfter(double This, double... inDoubleArray){
        double maxInDoubleArray = max(inDoubleArray);
        if(maxInDoubleArray <= This){ return 0; }
        double minNextAfterThis = maxInDoubleArray;
        for(double value : inDoubleArray){
            if(value > This & value < minNextAfterThis)
                minNextAfterThis = value;
        }
        return minNextAfterThis;
    }
}
