package InnerAbstractInterfacesPracticeTheFirst;

public class Square extends Rectangle {

    public Square(){
        super();
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String colour, boolean filled){
        super(side, side, colour, filled);
    }

    public void inputSide() {
        System.out.println("Input square side( like 1 or 0,213)");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userSide = scan.next();
            double side = Double.parseDouble(userSide);
            setWidth(side);
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid side value");
        }
    }

    @Override
    void inputColour() {
        System.out.print("What colour u need to paint square? (input like 'red' or 'black')");
        System.out.println();
        String colour;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        colour = scan.nextLine();
        setColour(colour);
    }

    @Override
    public void setWidth(double side) {
        if(side > 0) {
            super.setWidth(side);
            super.setLength(side);
        }
        else{
            System.out.println("inputted side not above zero");
        }
    }

    @Override
    public void setLength(double width) {
        this.setWidth(width);
    }

    @Override
    public String toString()
    {
        return  "A Square with side = " + this.getWidth() +
                ", which is a subclass of " + super.toString();
    }
}
