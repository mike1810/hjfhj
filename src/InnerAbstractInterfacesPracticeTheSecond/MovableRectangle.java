package InnerAbstractInterfacesPracticeTheSecond;

public class MovableRectangle implements IMovable{

    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    MovableRectangle(){
        this.topLeft = new MovablePoint(-1, 1,1,1);
        this.bottomRight = new MovablePoint(1,-1,0,0);
    }

    MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight){
        if(topLeft.isLeftAndTopAbove(bottomRight)){
            setTopLeft(topLeft);
            setBottomRight(bottomRight);
            if(!this.topLeft.speedEquals(this.bottomRight)){
                do{
                    inputSpeed();
                }
                while(this.topLeft.getXSpeed()<=0);
            }
        }else{
            System.out.println("Check coordinates to be correct if you need a new rectangle:");
            System.out.println("Top-Left " + topLeft + "\n" + "Bottom-Right "+ bottomRight);
        }
    }

    public void inputSpeed(){
        System.out.println("Input speed of rectangle moving:");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userSpeed = scan.next();
            double speed = Double.parseDouble(userSpeed);
            setSpeed(speed);
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid speed value");
        }

    }

    public void setTopLeft(MovablePoint topLeft) {
//        if(this.bottomRight.getX() <= topLeft.getX() && this.bottomRight.getY() >= topLeft.getY()){
//            System.out.println("Top-Left point must be to the left and higher than the Bottom-Right");
//        }else{
            this.topLeft = topLeft;
//        }
    }

    public void setBottomRight(MovablePoint bottomRight) {
//        if(this.topLeft.getX() >= bottomRight.getX() && this.topLeft.getY() <= bottomRight.getY()){
//            System.out.println("Bottom-Right point must be to the right and lower than the Top-Left");
//        }else{
            this.bottomRight = bottomRight;
//        }
    }

    public void setSpeed( double speed){
        if(speed <= 0){
            System.out.println("Speed can`t be 0 or less than 0");
        }else{
            bottomRight.setX(speed);
            bottomRight.setY(speed);
            topLeft.setX(speed);
            topLeft.setX(speed);
        }
    }
/*

    MovableRectangle(double squareSide, double squareCentreX,  double squareCentreY, double pointSpeed){
        setTopLeftWhenRectangleIsSquare(squareSide,squareCentreX,squareCentreY,pointSpeed);
    }

    public void setTopLeftWhenRectangleIsSquare(double squareSide, double squareCentreX,
                                                double squareCentreY, double pointSpeed){
        if(squareSide < 0){
            this.topLeft = new MovablePoint(
                    squareCentreX - squareSide / 2,
                    squareCentreY + squareSide / 2,
                    pointSpeed,
                    pointSpeed);
            this.bottomRight = new MovablePoint(
                    squareCentreX + squareSide / 2,
                    squareCentreY - squareSide / 2,
                    pointSpeed,
                    pointSpeed);
        }
    }

    MovableRectangle(double width, double height,
                     double rectangleCentreX, double rectangleCentreY, double pointSpeed){
        this.topLeft = new MovablePoint(
                rectangleCentreX - width / 2,
                rectangleCentreY + height / 2,
                pointSpeed,
                pointSpeed);
        this.bottomRight = new MovablePoint(
                rectangleCentreX + width / 2,
                rectangleCentreY - height / 2,
                pointSpeed,
                pointSpeed);
    }

*/



    public MovablePoint getBottomRight() {
        return bottomRight;
    }

    public MovablePoint getTopLeft() {
        return topLeft;
    }


    public void moveUp(){
        this.bottomRight.setY(this.bottomRight.getY() + bottomRight.getYSpeed());
        this.topLeft.setY(this.topLeft.getY() + topLeft.getYSpeed());
    }

    public void moveDown(){
        this.bottomRight.setY(this.bottomRight.getY() - bottomRight.getYSpeed());
        this.topLeft.setY(this.topLeft.getY() - topLeft.getYSpeed());
    }

    public void moveLeft(){
        bottomRight.setX(bottomRight.getX() - bottomRight.getXSpeed());
        topLeft.setX(topLeft.getX() - topLeft.getXSpeed());
    }

    public void moveRight(){
        bottomRight.setX(bottomRight.getX() + bottomRight.getXSpeed());
        topLeft.setX(topLeft.getX() + topLeft.getXSpeed());
    }

}
