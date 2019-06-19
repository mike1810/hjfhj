package inheritanceAndPolymorphismPracticeTheFirst;

public class Cylinder extends Circle {
    double height;

    public Cylinder() {
        super();
        this.height = 0.0;
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
        if(height >= 0) {
            this.height = height;
        }
        else{
            System.out.println("height less than zero");
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
                "area = " + getArea() +
                "volume = " + getVolume();
    }

}
