package obj_bas_pr5;

import java.util.Scanner;
import static java.lang.System.*;

public class TurtleGraphicsDemo {
    public static void main(String[] args) {
        TurtleGraphics turtle1 = new TurtleGraphics();
        turtleGraphicsBoardInit(turtle1);
        playTurtle(turtle1);
    }
    public static void turtleGraphicsBoardInit(TurtleGraphics turtle){
        Scanner scan = new Scanner(in);
        int width, height, userPenPositionX, userPenPositionY;
        out.println("Enter width (must be not less than 0)");
        width = scan.nextInt();
        out.println("Enter height (must be not less than 0)");
        height = scan.nextInt();
        turtle.turtleGraphicsBoardInit(width,height,userPenPositionX,userPenPositionY);
    }

    public static void playTurtle( TurtleGraphics turtle){
        Scanner scan = new Scanner(in);
        String moveOptionScan;
        while(true){
            turtle.showBoard();
            out.println("Move : u(up), d(down), l(left), r(right), c(for clear board)");
            moveOptionScan = scan.next();
            switch(moveOptionScan){
                case "u": turtle.movePen(TurtleGraphics.Direction.UP, getMoveSteps()); break;
                case "d": turtle.movePen(TurtleGraphics.Direction.DOWN, getMoveSteps()); break;
                case "l": turtle.movePen(TurtleGraphics.Direction.LEFT, getMoveSteps()); break;
                case "r": turtle.movePen(TurtleGraphics.Direction.RIGHT, getMoveSteps()); break;
                case "c": turtle.clearBoard();  break;
                default:
                    out.println("You don`t move like this: " + moveOptionScan);
            }
        }
    }
    public static int getMoveSteps(){
        Scanner scan = new Scanner(in);
        out.println("Enter the number of steps ");
        int moveSteps = scan.nextInt();
        return moveSteps;
    }

}
