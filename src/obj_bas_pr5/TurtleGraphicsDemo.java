package obj_bas_pr5;
import obj_bas_pr5.TurtleGraphics;
import obj_bas_pr5.Position;

public class TurtleGraphicsDemo {
    public static void main(String[] args) {
        TurtleGraphics turtle1 = new TurtleGraphics(7,5,2,3);
        turtle1.showBoard();
        System.out.println();
        turtle1.movePenRight(2);
        turtle1.showBoard();
        turtle1.movePenDown(1);
        turtle1.showBoard();
        turtle1.movePenLeft(1);
        turtle1.showBoard();
        turtle1.movePenUp(1);
        turtle1.showBoard();
        /*
        System.out.println();
        turtle1.movePenDown(1);
        turtle1.showBoard();
        System.out.println();
        turtle1.movePenLeft(1);
        turtle1.showBoard();
        System.out.println();
        */
    }

}
