package InnerAbstractInterfacesPracticeTheSecond;

public final class MovablePoint implements IMovable {

    private double x;

    private double y;

    private double ySpeed;

    private double xSpeed;

    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        this.x = x;
        this.y = y;
        this.setXSpeed(xSpeed);
        this.setYSpeed(ySpeed);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    void setXSpeed(double xSpeed) {
        if(xSpeed <= 0){
            System.out.println("Speed can`t be 0 or less than 0");
            this.xSpeed = 0;
        }
        this.xSpeed = xSpeed;
    }

    double getYSpeed() {
        return ySpeed;
    }

    void setYSpeed(double ySpeed) {
        if(ySpeed <= 0){
            System.out.println("Speed can`t be 0 or less than 0");
        }
        this.ySpeed = xSpeed;
    }

    public void moveUp(){
        this.y += ySpeed;
    }

    public void moveDown(){
        this.y -= ySpeed;
    }

    public void moveLeft(){
        this.x -= xSpeed;
    }

    public void moveRight(){
        this.x += xSpeed;
    }

    boolean isLeftAndTopAbove(MovablePoint obj) {
        if(this.x < obj.x && this.y > obj.y){
            return true;
        }else{
            return false;
        }
    }

    boolean speedEquals(MovablePoint obj) {
        if(this.xSpeed == obj.xSpeed && this.ySpeed == obj.ySpeed && this.xSpeed == this.ySpeed){
            return true;
        }else{
            return false;
        }
    }

    public static void printPoints(MovablePoint topLeft,MovablePoint bottomRight){
        System.out.println(
                "Top-Left " + topLeft +
                        " with xSpeed = " + topLeft.getXSpeed() +
                        " with wSpeed = " + topLeft.getYSpeed() +
                        "\nBottom-Right " + bottomRight +
                        " with xSpeed = " + bottomRight.getXSpeed() +
                        " with wSpeed = " + bottomRight.getYSpeed());
    }

    public static double returnNewCoordinate(){
        return (int)(Math.random()*50)-25;
    }

    public static double returnNewSpeed(){
        return (int)(Math.random()*5+1);
    }

    @Override
    public boolean equals(Object obj) {
        MovablePoint compared = (MovablePoint)obj;
        if(this.x == compared.x && this.y == compared.y &&
           this.ySpeed == compared.ySpeed && this.xSpeed == compared.xSpeed){
                 return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "point coordinates (" + this.x + ";" + this.y + ")";
    }
}
