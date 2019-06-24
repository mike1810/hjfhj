package InnerAbstractInterfacesPracticeTheSecond;

public class Demo {
    public static void main(String[] args) {

        MovablePoint topLeft = new MovablePoint(
                MovablePoint.returnNewCoordinate(),
                MovablePoint.returnNewCoordinate(),
                MovablePoint.returnNewSpeed(),
                MovablePoint.returnNewSpeed());

        MovablePoint bottomRight = new MovablePoint(
                MovablePoint.returnNewCoordinate(),
                MovablePoint.returnNewCoordinate(),
                MovablePoint.returnNewSpeed(),
                MovablePoint.returnNewSpeed());

        MovablePoint.printPoints(topLeft,bottomRight);

        System.out.println(
                "\nBottom-Right point is to the right and lower than the Top-Left: " +
                        topLeft.isLeftAndTopAbove(bottomRight));

        if(!topLeft.isLeftAndTopAbove(bottomRight)){
            MovableRectangle.createPointsNiceToCreateRectangle(topLeft, bottomRight);
        }

        MovableRectangle rectangle = new MovableRectangle(topLeft, bottomRight);
        System.out.println("\nYou created rectangle with this points:");
        System.out.println(rectangle);

        System.out.println("\nMove down rectangle by speed = " + rectangle.getRectangleSpeed());
        rectangle.moveDown();
        System.out.println(rectangle);

        System.out.println("\nMove left rectangle by speed = " + rectangle.getRectangleSpeed());
        rectangle.moveLeft();
        System.out.println(rectangle);

        System.out.println("\nMove up rectangle by speed = " + rectangle.getRectangleSpeed());
        rectangle.moveUp();
        System.out.println(rectangle);

        System.out.println("\nMove right rectangle by speed = " + rectangle.getRectangleSpeed());
        rectangle.moveRight();
        System.out.println(rectangle);
    }
}
