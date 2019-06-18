import static java.lang.System.out;
import java.util.InputMismatchException;
public class Stringsdad {

    public static void main(String[] args) {
        String userSettings = "10 wie 2 ";
        String[] userSettingsSplit = userSettings.split(" ");

        boolean firstWordIsIntegerType = true;
        int firstWord = 0;

        try {
            firstWord = Integer.parseInt(userSettingsSplit[0]);
        }
        catch(NumberFormatException ex){
            firstWordIsIntegerType = false;
        }

        if(firstWord <= 0){
            firstWordIsIntegerType = false;
        }

        out.println((firstWordIsIntegerType)?"Dogs array can be created":"Dogs array can`t be created");

        for(int i = 1; i < userSettingsSplit.length; i++){

        }

        if(firstWordIsIntegerType){
            giveDogName();
        }

    /*
    protected static Dog[] inputDogArrayFromString(String s){
        Dog[] dog = new Dog[]{};

        char[] charS = s.toCharArray();
        String firstChar = "";
        for(int i = 0; i < charS.length; i++) {
            if (charS[i + 1] != ' ') {
                firstChar += charS[i];
            }
        }
        out.println(firstChar);


        return dog;*/
    }
    static void giveDogName(){
    }
}