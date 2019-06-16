package obj_bas_pr5;
import obj_bas_pr5.TurtleGraphics;
import obj_bas_pr5.Position;

public class TurtleGraphicsDemo {
    public static void main(String[] args) {
    TurtleGraphics turtle1 = new TurtleGraphics(7,5,2,2);
    turtle1.showBoard();
    turtle1.movePenRight(1);
    turtle1.showBoard();
    turtle1.movePenLeft(2);
    turtle1.showBoard();
    }
}
