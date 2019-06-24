package inheritanceAndPolymorphismPracticeTheThird;

public class Demo {
    public static void main(String[] args){

        int[] intArray = new int[(int)java.lang.Math.random()*2+20];
        for(int i = 0; i < intArray.length; i++)
        {
            intArray[i] = (int)(java.lang.Math.random()*100);
        }
        System.out.println("Integer array:");
        for(int i: intArray){
            System.out.print(i + " ");
        }
        System.out.println( "\nmin: " + Math.min(intArray));
        System.out.println( "max: " + Math.max(intArray));
        System.out.println( "min in integer array that is above 15:" +
                Math.nextAfter( intArray, 15));
        System.out.println( "2 is raised to the power " + Math.min(intArray) +
                " = " + Math.pow(2, Math.min(intArray)));


        double[] doubleArray = new double[(int)java.lang.Math.random()*2+10];
        for(int i = 0; i < doubleArray.length; i++)
        {
            doubleArray[i] = java.lang.Math.random()*100;
        }

        System.out.println("\ndouble array:");
        for(double i: doubleArray){
            System.out.printf("%.3f ", i);
        }
        System.out.printf( "\nmin: %.3f ", Math.min(doubleArray));
        System.out.printf( "\nmax: %.3f ", Math.max(doubleArray));
        System.out.println( "\nmin in integer array that is above 15: " +
                Math.nextAfter( doubleArray, 15));
        int power = (int)(java.lang.Math.random()*10);
        System.out.println( "-2.000001 is raised to the power " + power +
                " = " + Math.pow(-2.000001, power));






    }

}
