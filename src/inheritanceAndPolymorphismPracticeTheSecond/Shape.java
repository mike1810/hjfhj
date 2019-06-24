package inheritanceAndPolymorphismPracticeTheSecond;

public class Shape {

    private String colour;
    private boolean filled;

    public Shape() {
        this.colour = "green";
        this.filled = true;
    }

    public Shape(String colour, boolean filled) {
        setColour(colour);
        setFilled(filled);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        if(Colour.checkColour(colour)) {
            this.colour = colour;
        } else {
            System.out.println("Colour can`t be like this");
        }
    }

    void inputColour() {
        System.out.println("What colour u need to paint? (input like 'red' or 'black')");
        String colour;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        colour = scan.nextLine();
        setColour(colour);
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    void inputFilled() {
        System.out.println("You need to fill the shape: true or false?");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        try {
            String userFilled = scan.next();
            boolean filled = Boolean.parseBoolean(userFilled);
            setFilled(filled);
        } catch (NumberFormatException ex) {
            System.out.println("Answer can be only 'true' or 'false'");
        }
    }

    @Override
    public String toString() {
        return (filled)?
                "A Shape with the colour of " + colour + " and filled" :
                "A Shape with the colour of " + colour + " and not filled";
    }
}