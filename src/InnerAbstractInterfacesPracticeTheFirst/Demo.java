package InnerAbstractInterfacesPracticeTheFirst;

public class Demo {

    public static void main(String[] args){

        Circle circle = new Circle(2);
        circle.inputColour();
        circle.inputFilled();
        circle.inputRadius();
        Rectangle rectangle = new Rectangle(2,2);
        rectangle.inputColour();
        rectangle.inputFilled();
        rectangle.inputWidth();
        rectangle.inputLength();
        Square square = new Square(2);
        square.inputColour();
        square.inputFilled();
        square.inputSide();
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        double x = inputPointX();
        double y = inputPointY();

        System.out.println(circle.isInside(x,y));
        System.out.println(rectangle.isInside(x,y));
        System.out.println(square.isInside(x,y));
    }

    public static double inputPointX(){
        System.out.println("Input X:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userX = scan.next();
            double X = Double.parseDouble(userX);
            return X;
        } catch(NumberFormatException ex){
            System.out.println("Invalid X value");
        }
        return Double.MAX_VALUE;
    }

    public static double inputPointY(){
        System.out.println("Input Y:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userY = scan.next();
            double Y = Double.parseDouble(userY);
            return Y;
        } catch(NumberFormatException ex){
            System.out.println("Invalid Y value");
        }
        return Double.MAX_VALUE;
    }

    public static void printAreaOrPerimeter(Shape[] shapeArray){
        for(Shape shape: shapeArray){
            if( shape instanceof Circle){
                System.out.print("\nCircle area: " + ((Circle) shape).getArea());
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
        /*
        for (Shape shape : shapeArray) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.printf("%s,\n Area is : %.2f\n\n",circle,circle.getArea());
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.printf("%s\n Perimeter is : %.2f",rectangle,rectangle.getPerimeter());
            }
        }
        */
    }


}