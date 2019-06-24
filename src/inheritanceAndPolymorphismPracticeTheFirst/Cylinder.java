package inheritanceAndPolymorphismPracticeTheFirst;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, Colour colour) {
        super(radius, colour);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        }
        else{
            System.out.println("inputted height not above zero");
        }
    }

    void inputHeight(){
        System.out.println("Input height( like 1 or 0,213)");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userHeight = scan.nextLine();
            double height = Double.parseDouble(userHeight);
            setHeight(height);
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid height value");
        }
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    @Override
    public double getArea() {
        return (2 * Math.PI * this.getRadius() * this.height + 2*super.getArea());
    }

    @Override
    public String toString()
    {
        return  "Cylinder:" + "\n" +
                "radius = " + this.getRadius() + "\n" +
                "colour = " + this.getColour() + "\n" +
                "area = " + getArea() + " m2\n" +
                "volume = " + getVolume() + " m3";
    }
}
