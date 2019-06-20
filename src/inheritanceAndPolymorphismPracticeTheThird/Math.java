package inheritanceAndPolymorphismPracticeTheThird;

public class Math {

    public static int min(int[] intArray){
        int min = intArray[0];
        for(int value : intArray){
            if(value < min)
                min = value;
        }
        return min;
    }

    public static double min(double[] intArray){
        double min = intArray[0];
        for(double value : intArray){
            if(value < min)
                min = value;
        }
        return min;
    }

    public static int max(int[] intArray){
        int min = intArray[0];
        for(int value : intArray){
            if(value > min)
                min = value;
        }
        return min;
    }

    public static double max(double[] intArray){
        double min = intArray[0];
        for(double value : intArray){
            if(value > min)
                min = value;
        }
        return min;
    }

    public static int nextAfter(int[] inIntArray, int This){
        int maxInIntArray = max(inIntArray);
        if(maxInIntArray <= This){ return 0; }
        int minNextAfterThis = maxInIntArray;
        for(int value : inIntArray){
            if(value > This & value < minNextAfterThis)
                minNextAfterThis = value;
        }
        return minNextAfterThis;
    }

    public static double nextAfter(double[] inDoubleArray, double This){
        double maxInDoubleArray = max(inDoubleArray);
        if(maxInDoubleArray <= This){ return 0; }
        double minNextAfterThis = maxInDoubleArray;
        for(double value : inDoubleArray){
            if(value > This & value < minNextAfterThis)
                minNextAfterThis = value;
        }
        return minNextAfterThis;
    }

    public static int pow(int intNumberIsRaisedToThePower, int power){
        int result = 1;
        if(power == 0){
            System.out.println("degree = 0");
            return 1;
        }
        if(intNumberIsRaisedToThePower == 0){
            System.out.println("first argument = 0");
            return 0;
        }if(power < 0){
            System.out.println("power < 0");
            return 0;
        }
        for(int i = 0; i < power; i++){
            result *= intNumberIsRaisedToThePower;
        }
        return result;
    }

    public static double pow(double doubleNumberIsRaisedToThePower, int power){
        double result = 1.0;
        if(power == 0.0){
            System.out.println("degree = 0");
            return 1.0;
        }
        if(doubleNumberIsRaisedToThePower == 0.0){
            System.out.println("first argument = 0");
            return 0.0;
        }if(power < 0.0){
            System.out.println("power < 0");
            return 0.0;
        }
        for(int i = 0; i < power; i++){
            result *= doubleNumberIsRaisedToThePower;
        }
        return result;
    }
}
