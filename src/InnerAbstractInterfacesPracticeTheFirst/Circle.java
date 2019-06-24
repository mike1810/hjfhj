package InnerAbstractInterfacesPracticeTheFirst;

public class Circle extends Shape{

    private double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super();
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        setRadius(radius);
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

    public void inputRadius() {
        System.out.println("Input circle radius( like 1 or 0,213)");
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

    public double getPerimeter() {
        return getCurcumference();
    }

    public double getCurcumference() {
        return 2*radius*Math.PI;
    }

    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2.0));
    }

    public boolean isInside( double x, double y ){
        return Math.pow((Math.pow(x,2) + Math.pow(y,2)), 0.5) <= this.radius;
    }

    @Override
    public String toString()
    {
        return  "A Circle with radius = " + radius +
                " which is a subclass of " + super.toString();
    }
}