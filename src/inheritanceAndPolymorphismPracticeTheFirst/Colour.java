package inheritanceAndPolymorphismPracticeTheFirst;

public enum Colour {
    RED("red"),
    ORANGE("orange"),
    GREEN("green"),
    BLACK("black"),
    L_BLUE("lite blue"),
    BLUE("blue");

    public String definition;

    Colour(String colour){
        this.definition = colour;
    }

    public String getDefinition() {
        return definition;
    }

    public String getColour() {
        return definition;
    }
    public static Colour getColour(String colour) {
        Colour getColour  = Colour.BLACK;
        Colour[] colourValues = Colour.values();
        for(Colour enumColour: colourValues) {
            if (enumColour.definition.equals(colour)) {
                getColour = enumColour;
            }
        }
        return getColour;
    }

    public static boolean checkColour(String colour){
        boolean check = false;
        Colour[] colourValues = Colour.values();
        for(Colour enumColour: colourValues){
            if(enumColour.definition.equals(colour)){
                check = true;
            }
        }
        return check;
    }

}
