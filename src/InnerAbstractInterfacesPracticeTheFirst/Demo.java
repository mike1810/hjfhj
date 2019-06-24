package InnerAbstractInterfacesPracticeTheFirst;

public class Demo {

    public static void main(String[] args){
        boolean needsToInputShapes;
        needsToInputShapes = inputUserNeedsToInputShapes();

        Circle circle = new Circle((int)(Math.random()*20+5));
        if(needsToInputShapes) {
            circle.inputColour();
            circle.inputFilled();
            circle.inputRadius();
        }

        Rectangle rectangle = new Rectangle((int)(Math.random()*20+5),(int)(Math.random()*20+5));
        if(needsToInputShapes) {
            rectangle.inputColour();
            rectangle.inputFilled();
            rectangle.inputWidth();
            rectangle.inputLength();
        }

        Square square = new Square((int)(Math.random()*20+5));
        if(needsToInputShapes) {
            square.inputColour();
            square.inputFilled();
            square.inputSide();
        }

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        Shape[] shape = new Shape[]{circle,rectangle,square};
        printAreaAndPerimeterAndCheckPoint(shape);
    }

    public static double inputPointX(){
        System.out.println("Input X:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        double X;
        try {
            String userX = scan.next();
            X = Double.parseDouble(userX);
            return X;
        } catch(NumberFormatException ex){
            System.out.print("Invalid X value. ");
            X = inputPointX();
        }
        return X;
    }
    public static boolean inputUserNeedsToInputShapes(){
        System.out.println("If you need to input shapes yourselves press '1', if don`t - press '2'");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        boolean userNeedsToInputShapes;
        int userNeeds;
        try {
            String userX = scan.next();
            userNeeds = Integer.parseInt(userX);
            if (userNeeds == 1) {
                userNeedsToInputShapes = true;
            }else
            if(userNeeds == 2){
                userNeedsToInputShapes = false;
            }else{
                System.out.print("Invalid value. ");
                userNeedsToInputShapes = inputUserNeedsToInputShapes();
            }
        }catch(NumberFormatException ex){
            System.out.print("Invalid value. ");
            userNeedsToInputShapes = inputUserNeedsToInputShapes();
        }
        return userNeedsToInputShapes;
    }

    public static double inputPointY(){
        System.out.println("Input Y:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        double Y;
        try {
            String userY = scan.next();
            Y = Double.parseDouble(userY);
            return Y;
        } catch(NumberFormatException ex){
            System.out.print("Invalid Y value. ");
            Y = inputPointX();
        }
        return Y;
    }

    public static void printAreaAndPerimeterAndCheckPoint(Shape[] shapeArray){

        System.out.println();
        double x = inputPointX();
        System.out.println();
        double y = inputPointY();

        for (Shape shape : shapeArray) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.printf("\nCircle:\nArea is : %.3f\nPerimeter(curcumference) : %.3f\n",circle.getArea(),circle.getPerimeter());
                System.out.printf("Radius: %.3f\n", circle.getRadius());
                System.out.printf("Point (%.3f;%.3f) is inside circle: %b\n", x, y, circle.isInside(x,y));
            } else if(shape instanceof Square) {
                Square square = (Square) shape;
                System.out.printf("\nSquare:\nArea is : %.3f\nPerimeter : %.3f\n",square.getArea(),square.getPerimeter());
                System.out.printf("Width: %.3f\nLength: %.3f\n", square.getWidth(), square.getLength());
                System.out.printf("Point (%.3f;%.3f) is inside square: %b\n", x, y, square.isInside(x,y));
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.printf("\nRectangle:\nArea is : %.3f\nPerimeter : %.3f\n",rectangle.getArea(),rectangle.getPerimeter());
                System.out.printf("Width: %.3f\nLength: %.3f\n", rectangle.getWidth(), rectangle.getLength());
                System.out.printf("Point (%.3f;%.3f) is inside rectangle: %b\n", x, y, rectangle.isInside(x,y));
            }
        }
    }


}