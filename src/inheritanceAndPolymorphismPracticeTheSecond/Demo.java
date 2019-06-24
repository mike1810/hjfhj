package inheritanceAndPolymorphismPracticeTheSecond;

public class Demo {

    public static void main(String[] args){

        Circle circle = new Circle();
        circle.inputColour();
        circle.inputFilled();
        circle.inputRadius();
        Rectangle rectangle = new Rectangle();
        rectangle.inputColour();
        rectangle.inputFilled();
        rectangle.inputWidth();
        rectangle.inputLength();
        Square square = new Square();
        square.inputColour();
        square.inputFilled();
        square.inputSide();
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
        Shape[] shapeArray = new Shape[]{circle,rectangle, square};
        printAreaOrPerimeter(shapeArray);

    }
    public static void printAreaOrPerimeter(Shape[] shapeArray){
        for(Shape shape: shapeArray){
            if( shape instanceof Circle){
                System.out.println("Circle area: " + ((Circle) shape).getArea());
                continue;
            }
            if( shape instanceof Square){
                System.out.print("\nSquare perimeter: " + ((Square) shape).getPerimeter());
                continue;
            }
            if( shape instanceof Rectangle){
                System.out.print("\nRectangle perimeter: " + ((Rectangle) shape).getPerimeter());
                continue;
            }
        }
    }
}