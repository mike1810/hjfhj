package InnerAbstractInterfacesPracticeTheFirst;

import inheritanceAndPolymorphismPracticeTheSecond.Colour;

public abstract class Shape {

    private String colour;
    private boolean filled;

    Shape() {
        this.colour = "green";
        this.filled = true;
    }

    Shape(String colour, boolean filled) {
        setColour(colour);
        setFilled(filled);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if (Colour.checkColour(colour)) {
            this.colour = colour;
        } else {
            System.out.println("Colour can`t be like this");
        }
    }

    void inputColour(){
        boolean isCircle = false, isSquare = false, isRectangle = false;
        if(this instanceof Circle){
            isCircle = true;
        }
        if(this instanceof Square){
            isSquare = true;
        }else{
            if(this instanceof Rectangle){
                isRectangle = true;
            }
        }
        if(isCircle){System.out.println("What colour u need to paint circle? (input like 'red' or 'black')");}
        if(isSquare){System.out.println("What colour u need to paint square? (input like 'red' or 'black')");}
        if(isRectangle){System.out.println("What colour u need to paint rectangle? (input like 'red' or 'black')");}

        System.out.println();
        String colour;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        colour = scan.nextLine();
        setColour(colour);

    };


    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    void inputFilled(){
        boolean isCircle = false, isSquare = false, isRectangle = false;
        if(this instanceof Circle){
            isCircle = true;
        }
        if(this instanceof Square){
            isSquare = true;
        }else{
            if(this instanceof Rectangle){
                isRectangle = true;
            }
        }
        if(isCircle){System.out.println("You need to fill circle: true or false?");}
        if(isSquare){System.out.println("You need to fill square: true or false?");}
        if(isRectangle){System.out.println("You need to fill rectangle: true or false?");}


        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userFilled = scan.next();
            boolean filled = Boolean.parseBoolean(userFilled);
            setFilled(filled);
        } catch (NumberFormatException ex) {
            System.out.println("Answer can be only 'true' or 'false'");
        }
    };


    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside( double x, double y );



    @Override
    public String toString() {
        return (filled) ?
                "A Shape with the colour of " + colour + " and filled" :
                "A Shape with the colour of " + colour + " and not filled";
    }
}