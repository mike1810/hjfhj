package InnerAbstractInterfacesPracticeTheSecond;

public class Demo {
    public static void main(String[] args) {
        MovablePoint topLeft = new MovablePoint(0,3,4,4);
        MovablePoint bottomRight = new MovablePoint(1,2,-3,4);
        System.out.println(topLeft.speedEquals(bottomRight));
        System.out.println(topLeft.isLeftAndTopAbove(bottomRight));
        System.out.println(topLeft + "\n" + bottomRight);

        //MovableRectangle rectangle = new MovableRectangle(topLeft, bottomRight);
        MovableRectangle rectangle = new MovableRectangle(bottomRight, topLeft);
        System.out.println(rectangle.getTopLeft() + " " + rectangle.getBottomRight());
        System.out.println(topLeft.isLeftAndTopAbove(bottomRight));
        rectangle.moveDown();
        System.out.println(rectangle.getTopLeft() + " " + rectangle.getBottomRight());
        rectangle.moveLeft();
        System.out.println(rectangle.getTopLeft() + " " + rectangle.getBottomRight());
        rectangle.moveUp();
        System.out.println(rectangle.getTopLeft() + " " + rectangle.getBottomRight());
        rectangle.moveRight();
        System.out.println(rectangle.getTopLeft() + " " + rectangle.getBottomRight());


    }

}
