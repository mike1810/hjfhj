package inheritanceAndPolymorphismPracticeTheFirst;

public class Circle {

    private double radius;
    private Colour colour;

    public Circle() {
        this.radius = 1.0;
        this.colour = Colour.BLACK;
    }

    public Circle(double radius) {
        this(radius, Colour.BLACK);
    }

    public Circle(double radius, Colour color) {
        setRadius(radius);
        this.colour = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius > 0) {
            this.radius = radius;
        }
        else{
            System.out.println("inputted radius not above zero");
        }
    }

    void inputRadius() {
        System.out.println("Input radius( like 1 or 0,213)");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userRadius = scan.next();
            double radius = Double.parseDouble(userRadius);
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

    public void setColour(Colour colour) {
        if(Colour.checkColour(colour.getDefinition())) {
            this.colour = colour;
        } else {
            System.out.println("Colour can`t be like this");
        }
    }

    public void setColour(String colour) {
        if(Colour.checkColour(colour)) {
            this.colour = Colour.getColour(colour);
        } else {
            System.out.println("Colour can`t be like this");
        }
    }

    void inputColour() {
        System.out.println("Input colour( like 'red' or 'black')");
        String colour;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        colour = scan.nextLine();
        setColour(colour);
    }

    @Override
    public String toString()
    {
        return  "Circle:" + "\n" +
                "radius = " + this.radius + "\n" +
                "colour = " + this.colour + "\n" +
                "area = " + getArea() + " m2";
    }
}
