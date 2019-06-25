package GenericsTheSecond;

import InnerAbstractInterfacesPracticeTheFirst.Rectangle;

public class Demo {
    public static void main(String[] args){
/*

        System.out.println(
                "After that, print out values in variables:\n"
                        + "1) integer: " + integer + "\n"
                        + "2) square: " + square + "\n");

        System.out.println(
                "We created a genericEquals:\n"
                        + "1) integer: " + integer + "\n"
                        + "2) square: " + square + "\n");

*/



        GenericEquals<Rectangle> RectanglePair
                = new GenericEquals<>();
        System.out.println(
                RectanglePair.equals(
                new Rectangle((int)(Math.random()*4),(int)(Math.random()*2)),
                new Rectangle((int)(Math.random())*4,(int)(Math.random()*2)))
        );

        //GenericEqualsOnlyForString <Integer> onlyForString = new GenericEquals<Integer>(2);

        System.out.println(
                "We created variable 'onlyForString' type of GenericEqualsOnlyForString \n");

        GenericEqualsOnlyForString onlyForString = new GenericEqualsOnlyForString();
        onlyForString.equals("qwe","qwe");


        // Theirs width is in [0;4] like value 1 or 3
        // Theirs length is in [0,2] like value 0 or 1

    }
}
