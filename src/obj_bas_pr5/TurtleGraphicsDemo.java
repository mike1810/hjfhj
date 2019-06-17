package obj_bas_pr5;

import java.util.Scanner;
import static java.lang.System.*;

public class TurtleGraphicsDemo {
    public static void main(String[] args) {
        TurtleGraphics turtle1;
        turtle1 = turtleGraphicsBoardInit();
        playTurtle(turtle1);
    }
    public static TurtleGraphics turtleGraphicsBoardInit(){
        Scanner scan = new Scanner(in);
        int width, height, userPenPositionX = 0, userPenPositionY = 0;

        out.println("Enter board width (must be not less than 1 and not more than 15)");
        width = scan.nextInt();
        width = (width <= 0 || width > 15)?15:width;

        out.println("Enter board height (must be not less than 1 and not more than 15)");
        height = scan.nextInt();
        height = (height <= 0 || height > 15)?15:height;

        out.println("Enter turtle position (x;y) where X in [0;" + width + "), Y in [0;" + height + ")" );
        out.print("X = ");userPenPositionX = scan.nextInt();
        out.print("Y = ");userPenPositionY = scan.nextInt();
        userPenPositionX = (userPenPositionX < 0 || userPenPositionX >= width)?0:userPenPositionX;
        userPenPositionY = (userPenPositionY < 0 || userPenPositionY >= height)?0:userPenPositionY;

        TurtleGraphics turtle = new TurtleGraphics(height,width,userPenPositionX,userPenPositionY);
        turtle.getPosition();
        return turtle;
    }

    public static void playTurtle( TurtleGraphics turtle){
        Scanner scan = new Scanner(in);
        String moveOptionScan;

        boolean userLearned = false;
        while(true){
            turtle.showBoard();
            out.println((userLearned) ?
                    "Move : u(up), d(down), l(left), r(right), c(for clear board)":(
                    "First, you can move:" +
                            "\n1) up (using 'u')" +
                            "\n2) down (using 'd')" +
                            "\n3) left (using 'l')" +
                            "\n4) right (using 'r')" +
                            "\nAfter entering one of this hotkeys , press 'Enter'" +
                            "\nIf you need to clear board, press 'c' -> 'Enter'" +
                            "\nLet`s play:")
                    );
            moveOptionScan = scan.next();
            if(!userLearned){
                out.println("After inputting direction you need to input number of steps:" +
                        "\nLet`s do this:");
            }
            switch(moveOptionScan){
                case "u": turtle.movePen(TurtleGraphics.Direction.UP, getMoveSteps()); break;
                case "d": turtle.movePen(TurtleGraphics.Direction.DOWN, getMoveSteps()); break;
                case "l": turtle.movePen(TurtleGraphics.Direction.LEFT, getMoveSteps()); break;
                case "r": turtle.movePen(TurtleGraphics.Direction.RIGHT, getMoveSteps()); break;
                case "c": turtle.clearBoard();  break;
                default:
                    out.println("You don`t move like this: " + moveOptionScan);
            }
            userLearned = true;
        }
    }
    public static int getMoveSteps(){
        Scanner scan = new Scanner(in);
        out.println("Enter the number of steps ");
        int moveSteps = scan.nextInt();
        return moveSteps;
    }

}
