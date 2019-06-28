package ExceptionsPractice.CatchMultipleExceptions;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args){

        boolean first = false,
                second = false,
                third = false,
                inputted = false;
        Scanner scan = new Scanner(System.in);
        Integer type;

        while(!inputted){
            System.out.println("Input(1 or 2 or 3) exception type you need to exercise:" +
                    "\n1: First" +
                    "\n2: Second" +
                    "\n3: Third");
            try{
                String sType = scan.next();
                type = Integer.parseInt(sType);
                if(type == 1){
                    first = true;
                    inputted = true;}
                if(type == 2){
                    second = true;
                    inputted = true;}
                if(type == 3){
                    third = true;
                    inputted = true;
                }
            }catch(NumberFormatException e){
                System.out.println("Input only '1','2','3'");
            }
        }

        try{
            if(first) {
                throw new TypeOne("First type exception message");
            }
            if(second){
                throw new TypeTwo("Second type exception message");
            }
            if(third) {
                throw new TypeThree("Third type exception message");
            }
        }catch(TypeOne | TypeTwo | TypeThree e){
            System.out.println(e.getMessage());
        }
    }
}