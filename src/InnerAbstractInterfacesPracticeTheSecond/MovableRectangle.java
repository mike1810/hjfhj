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
            setTopLeftConstructor(topLeft);
            setBottomRight(bottomRight);
            if(!this.topLeft.speedEquals(this.bottomRight)){
                    inputSpeed();
            }
        }
        else{makePointsCorrectToCreateRectangle(topLeft,bottomRight);
        }
    }

    private static void makeTopLeftCorrectToCreateRectangle(MovablePoint topLeft, MovablePoint bottomRight){
        int leftXGoRightAndRightXGoLeft = 0;
        int topXGoBottomAndBottomXGoTop = 0;
        if(!topLeft.isLeftAndTopAbove(bottomRight)){
            while(!topLeft.isLeftAndTopAbove(bottomRight)){
                if(topLeft.getX() >= bottomRight.getX()){
                    topLeft.setX(topLeft.getX() - topLeft.getXSpeed());
                    leftXGoRightAndRightXGoLeft++;
                }
                if(topLeft.getY() <= bottomRight.getY()) {
                    topLeft.setY(topLeft.getY() + topLeft.getYSpeed());
                    topXGoBottomAndBottomXGoTop++;
                }
            }
        }
        if(leftXGoRightAndRightXGoLeft !=0) {
            System.out.println(
                    "Top-Left X decreased by '" + topLeft.getXSpeed() +
                            "' '" + leftXGoRightAndRightXGoLeft + "' times;");
        }
        if(topXGoBottomAndBottomXGoTop != 0){
            System.out.println(
                    "Top-Left Y increased by '" + topLeft.getYSpeed() +
                            "' '" + topXGoBottomAndBottomXGoTop +"' times;");
        }
    }

    private static void makeBottomRightCorrectToCreateRectangle(MovablePoint topLeft, MovablePoint bottomRight){
        int leftXGoRightAndRightXGoLeft = 0;
        int topXGoBottomAndBottomXGoTop = 0;
        if(!topLeft.isLeftAndTopAbove(bottomRight)){
            while(!topLeft.isLeftAndTopAbove(bottomRight)){
                if(topLeft.getX() >= bottomRight.getX()){
                    bottomRight.setX(bottomRight.getX() + bottomRight.getXSpeed());
                    leftXGoRightAndRightXGoLeft++;
                }
                if(topLeft.getY() <= bottomRight.getY()) {
                    bottomRight.setY(bottomRight.getY() - bottomRight.getYSpeed());
                    topXGoBottomAndBottomXGoTop++;
                }
            }
        }
        if(leftXGoRightAndRightXGoLeft !=0) {
            System.out.println(
                    "Bottom-Right X increased by '" + bottomRight.getXSpeed() +
                            "' '" + leftXGoRightAndRightXGoLeft + "' times;");
        }
        if(topXGoBottomAndBottomXGoTop != 0){
            System.out.println(
                    "Bottom-Right X decreased by '" + bottomRight.getYSpeed() +
                            "' '" + topXGoBottomAndBottomXGoTop +"' times;");
        }
    }

    private static void makePointsCorrectToCreateRectangle(MovablePoint topLeft, MovablePoint bottomRight){
        int leftXGoRightAndRightXGoLeft = 0;
        int topXGoBottomAndBottomXGoTop = 0;
        if(!topLeft.isLeftAndTopAbove(bottomRight)){
            while(!topLeft.isLeftAndTopAbove(bottomRight)){
                if(topLeft.getX() >= bottomRight.getX()){
                    topLeft.setX(topLeft.getX() - topLeft.getXSpeed());
                    bottomRight.setX(bottomRight.getX() + bottomRight.getXSpeed());
                    leftXGoRightAndRightXGoLeft++;
                }
                if(topLeft.getY() <= bottomRight.getY()) {
                    topLeft.setY(topLeft.getY() + topLeft.getYSpeed());
                    bottomRight.setY(bottomRight.getY() - bottomRight.getYSpeed());
                    topXGoBottomAndBottomXGoTop++;
                }
            }
        }
        if(leftXGoRightAndRightXGoLeft !=0) {
            System.out.println(
                    "Top-Left X decreased by '" + topLeft.getXSpeed() +
                            "' '" + leftXGoRightAndRightXGoLeft + "' times;");
            System.out.println(
                    "Bottom-Right X increased by '" + bottomRight.getXSpeed() +
                            "' '" + leftXGoRightAndRightXGoLeft + "' times;");
        }
        if(topXGoBottomAndBottomXGoTop != 0){
            System.out.println(
                    "Top-Left Y increased by '" + topLeft.getYSpeed() +
                            "' '" + topXGoBottomAndBottomXGoTop +"' times;");
            System.out.println(
                    "Bottom-Right X decreased by '" + bottomRight.getYSpeed() +
                            "' '" + topXGoBottomAndBottomXGoTop +"' times;");
        }
    }

    static void createPointsNiceToCreateRectangle(MovablePoint topLeft, MovablePoint bottomRight){
        System.out.println("\nYou can`t create rectangle with this points cause of:");
        if(topLeft.getX() >= bottomRight.getX()){
            System.out.println(
                    "Top-Left X > Bottom-Right X (" +
                            topLeft.getX() + ">=" + bottomRight.getX() +")");
        }
        if(topLeft.getY() <= bottomRight.getY()) {
            System.out.println(
                    "Top-Left Y < Bottom-Right Y (" +
                            topLeft.getY() + "<=" + bottomRight.getY() + ")");
        }
        System.out.println();
        makeTopLeftCorrectToCreateRectangle(topLeft, bottomRight);
        makeBottomRightCorrectToCreateRectangle(topLeft, bottomRight);

        //makePointsCorrectToCreateRectangle(topLeft, bottomRight);
    }

    private void inputSpeed(){
        System.out.println("Input speed of rectangle moving(one speed value for all coordinates):");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userSpeed = scan.next();
            double speed = Double.parseDouble(userSpeed);
            setSpeed(speed);
        }
        catch(NumberFormatException ex){
            System.out.print("Invalid speed value. ");
            inputSpeed();
        }

    }

    void setTopLeftConstructor(MovablePoint topLeft) {
        this.topLeft = topLeft;
    }

    void setTopLeft(MovablePoint topLeft) {
        if(topLeft.isLeftAndTopAbove(bottomRight)){
            this.topLeft = topLeft;
        }else{
            makeTopLeftCorrectToCreateRectangle(topLeft, bottomRight);
            this.topLeft = topLeft;
        }
        if(!topLeft.speedEquals(bottomRight)){
            inputSpeed();
        }
    }

    void setBottomRight(MovablePoint bottomRight) {
        if(topLeft.isLeftAndTopAbove(bottomRight)){
            this.bottomRight = bottomRight;
        }else{
            makeTopLeftCorrectToCreateRectangle(topLeft, bottomRight);
            this.bottomRight = bottomRight;
        }
        if(!topLeft.speedEquals(bottomRight)){
            inputSpeed();
        }
    }

    void setSpeed( double speed){
        if(speed <= 0){
            System.out.println("Speed '" + speed + "' replaced by '" + (-speed) + "cause of negative speed value");
            bottomRight.setXSpeed(-speed);
            bottomRight.setYSpeed(-speed);
            topLeft.setXSpeed(-speed);
            topLeft.setYSpeed(-speed);
        }else{
            bottomRight.setXSpeed(speed);
            bottomRight.setYSpeed(speed);
            topLeft.setXSpeed(speed);
            topLeft.setYSpeed(speed);
        }
    }

    MovablePoint getBottomRight() {
        return bottomRight;
    }

    MovablePoint getTopLeft() {
        return topLeft;
    }

    double getRectangleSpeed(){
        return topLeft.getXSpeed();
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

    @Override
    public String toString(){
        return "Top-Left " + topLeft + "Bottom-Right " + bottomRight;
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
}
