package inheritanceAndPolymorphismPracticeTheFirst;

public class Demo {
    public static void main(String[] args){
        Circle a = new Circle(5);
        a.setRadius(-3);
        a.setRadius(3);
        a.setColour("lite blue");
        a.setColour("red");
        System.out.println(a);
    }
}
