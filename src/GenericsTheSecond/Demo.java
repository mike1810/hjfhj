package GenericsTheSecond;

public class Demo {
    public static void main(String[] args) {

        Vine fanagoria = new Vine
                ("Fanagoria", 0.75, 12.5, 329.9);
        Vine torreBlanca = new Vine
                ("Torre-Blanca", 0.5, 12.5, 699.0 );

        System.out.println( "Compare result of two vine names: " +
                GenericMethod.compareTo(fanagoria, torreBlanca));

        Vine torreBlancaLowCost = new Vine
                ("Torre-Blanca", 0.5, 12.5, 399.0 );

        System.out.println( "Compare result of two vine names: " +
                GenericMethod.compareTo(torreBlancaLowCost, torreBlanca));

        Lemonade cola = new Lemonade("Coca-cola", 1, 100);
        Lemonade sevenUp = new Lemonade("7UP", 1, 90);

        System.out.println( "Compare result of two lemonade names: " +
                GenericMethod.compareTo(cola, sevenUp));

        Vine colaVine = new Vine
                ("Coca-cola", 0.75, 12.5, 329.9);

        System.out.println( "Compare result of two: lemonade and vine names: " +
                GenericMethod.compareTo(colaVine, cola));
    }
}