package inheritanceAndPolymorphismPracticeTheFirst;

public class Demo {
    public static void main(String[] args){
        Circle circle = new Circle();
        circle.inputRadius();
        circle.inputColour();
        System.out.println(circle);
        Cylinder cylinder = new Cylinder(2);
        cylinder.inputRadius();
        cylinder.inputColour();
        System.out.println(cylinder);
        System.out.println(cylinder.getRadius());
    }
}
