package inheritanceAndPolymorphismPracticeTheFirst;
import java.lang.Math;

public class Circle {

    private double radius;
    private Colour colour;


    public Circle() {
        this.radius = 0.0;
        this.colour = Colour.BLACK;
    }

    public Circle(double radius) {
        this.radius = radius;
        this.colour = Colour.BLACK;
    }

    public Circle(double radius, Colour colour) {
        this.radius = radius;
        this.colour = colour;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius >= 0) {
            this.radius = radius;
        }
        else{
            System.out.println("radius less than zero");
        }
    }

    public void inputRadius() {
        System.out.println("Input radius( like 0 or 0,213)");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String text = scan.nextLine();
            double radius = Double.parseDouble(text);
            setRadius(radius);
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid radius value");
        }
    }

    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2.0));
    }

    public Colour getColour() {
        return this.colour;
    }

    public void printColour() {
        System.out.println(this.colour);
    }

    public void setColour(String colour) {
        if(Colour.checkColour(colour)) {
            this.colour = Colour.getColour(colour);
        } else {
            System.out.println("Colour can`t be like this");
        }
    }
    //
    public void inputColour() {
        System.out.println("Input colour( like 'red' or 'black')");
        String colour = "";
        java.util.Scanner scan = new java.util.Scanner(System.in);
        colour = scan.nextLine();
        setColour(colour);
    }
    //

    @Override
    public String toString()
    {
        return  "Circle:" + "\n" +
                "radius = " + this.radius + "\n" +
                "colour = " + this.colour + "\n" +
                "area = " + getArea();
    }
}
