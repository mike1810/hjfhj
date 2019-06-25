package Generics.GenericsTheFirst;

import InnerAbstractInterfacesPracticeTheFirst.Square;
import InnerAbstractInterfacesPracticeTheFirst.Rectangle;

public class Demo {
    public static void main(String[] args){

        System.out.println(
                        "We will create a GenericPair 'integerAndSquare' with two arguments:\n"
                        + "First argument bounds are upper with a type of Number subclasses.\n"
                        + "Second argument bounds are upper too with a type of Rectangle subclasses.\n");

        GenericPair<Integer, Square> integerAndSquare
                = new GenericPair<Integer, Square>
                (1, new Square(2, "black", true));

        System.out.println(
                        "Next, we created two variables type of Integer('integer') and Square('square').\n"
                        + "GenericPair`s method getFirst() retrieves"
                        + " the first value of GenericPair into 'integer'.\n"
                        + "GenericPair`s method getSecond() retrieves"
                        + " the second value of GenericPair into 'square'.\n");

        Integer integer = integerAndSquare.getFirst();
        Square square = integerAndSquare.getSecond();

        System.out.println(
                        "After that, print out values in variables:\n"
                        + "1) integer: " + integer + "\n"
                        + "2) square: " + square + "\n");

        GenericPair<? super Integer, ? super Square> superOfIntegerAndSquare = integerAndSquare;

        System.out.println(
                        "We created a GenericPair 'superOfIntegerAndSquare' which has a lower bounds:\n"
                        + "First argument is a superclass of Integer, includes value of 'integerAndSquare'.\n"
                        + "Second argument is a superclass of Square, includes value of 'integerAndSquare'.\n"
                        + "\nAt the result, we can use methods to retrieve values into variables "
                        + "of Type Number('number') or Rectangle('rectangle')."
                        + "\nBut we can`t use them "
                        + "to retrieve values into variables like Integer or Square like: \n"
                        + "'Integer num = superOfIntegerAndSquare.getFirst();'\n" );

        Number number = superOfIntegerAndSquare.getFirst();
        Rectangle rectangle = superOfIntegerAndSquare.getSecond();

        System.out.println(
                        "After that, print out values in variables:\n"
                        + "1) number: " + number + "\n"
                        + "2) rectangle: " + rectangle + "\n");
/*
        // it works, but i don`t know why we need 'integerAndSquare' transformed
        // to 'subOfSuperOfIntegerAndSquare'
        GenericPair<? extends Number, ? extends Rectangle> subOfSuperOfIntegerAndSquare =
        superOfIntegerAndSquare;
*/

        System.out.println(
                        "We will create an object 'stringAndNumber' \n"
                        + "type of GenericPairWithoutBounds with two arguments:\n"
                        + "1) First argument bounds has a type of String subclasses.\n"
                        + "2) Second argument bounds has a type of Number subclasses.\n");

        GenericPairWithoutBounds<String, Number> stringAndNumber
                = new GenericPairWithoutBounds<String, Number>
                ("i`m first value", 2);

        System.out.println(
                        "Print out the result of methods: getFirst(), getSecond() for 'stringAndNumber':\n"
                        + "integer: " + stringAndNumber.getFirst() + "\n"
                        + "square: " + stringAndNumber.getSecond() + "\n");
    }
}
