package obj_bas_pr5;
import static java.lang.System.*;

public class TurtleGraphics {
    public char board [][];
    public Position penPosition;
    public char cellChar;//'.'
    public char coloredCellChar;//'o'
    public char penChar;//'x'
    {
        this.penPosition = new Position(0,0);
        this.cellChar = '.';
        this.coloredCellChar = 'o';
        this.penChar = 'x';
        this.board = new char[5][5];
        this.turtleGraphicsInit();
    }
    TurtleGraphics(int length, int width, int penPositionX, int penPositionY){
        this.penPosition = new Position(penPositionX, penPositionY);
        board = new char[width][length];
        turtleGraphicsInit();
    }
    private void turtleGraphicsInit(){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = cellChar;
            }
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    public void showBoard(){
        for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++)
        {
            out.print(board[i][j] + " ");
        }
        out.println();
        }
    }
    public void movePen(Direction dir,int length){

    }
    public void movePenUp(int length){
    }
    public void movePenRight(int length){

        int posY = penPosition.getY();
        int posX = penPosition.getY();
        for(int j = penPosition.getY(); j <=  posY + length; j++){
            board[penPosition.getX()][j] = coloredCellChar;
            penPosition.setY(j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    public void movePenLeft(int length){
        int posY = penPosition.getY();
        int posX = penPosition.getY();
        for(int j = penPosition.getY(); j >=  posY - length; j--){
            board[penPosition.getX()][j] = coloredCellChar;
            penPosition.setY(j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;

    }
    public void movePenDown(int length){

    }





    enum Direction{
        up('u'),down('d'),left('l'),right('r');
        char code;
        Direction(char code){this.code = code;}
    }
}
