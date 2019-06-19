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


}
