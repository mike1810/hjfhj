package obj_bas_pr5;
import static java.lang.System.*;

public class TurtleGraphics {
    private char[][] board;
    private Position penPosition;
    private char cellChar;//'.'
    private char coloredCellChar;//'o'
    private char penChar;//'x'
    {
        this.penPosition = new Position(0,0);
        this.cellChar = '.';
        this.coloredCellChar = 'o';
        this.penChar = 'x';
        this.board = new char[5][5];
        this.turtleGraphicsBoardInit();
    }
    TurtleGraphics(){
        turtleGraphicsBoardInit();
    }
    TurtleGraphics(int length, int width, int penPositionX, int penPositionY){
        this.penPosition = new Position(penPositionX, penPositionY);
        board = new char[width][length];
        turtleGraphicsBoardInit();
    }
    protected void turtleGraphicsBoardInit(int length, int width, int penPositionX, int penPositionY){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = cellChar;
            }
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    private void turtleGraphicsBoardInit(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = cellChar;
            }
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    protected void clearBoard(){
        penPosition.setX(0);
        penPosition.setY(0);
        turtleGraphicsBoardInit();
    }
    protected void showBoard(){
        for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[i].length; j++)
        {
            out.print(board[i][j] + " ");
        }
        out.println();
        }
    }
    protected void movePen(Direction dir, int length){
        if(dir.code == 'u'){
            length = (this.penPosition.getX() - length < 0) ? this.penPosition.getX() : length;
            movePenUp(length);
        }
        if(dir.code == 'd'){
            length = (this.penPosition.getX() +  length  >= board.length - 1) ?
                     (board.length - (this.penPosition.getX()+1)) : length;
            movePenDown(length);
        }
        if(dir.code == 'l'){
            length = (this.penPosition.getY() - length < 0) ? this.penPosition.getY() : length;
            movePenLeft(length);
        }
        if(dir.code == 'r'){
            length = (this.penPosition.getY() +  length  >= board[penPosition.getX()].length - 1) ?
                    (board[penPosition.getX()].length - (this.penPosition.getY()+1)) : length;
            movePenRight(length);
        }
    }
    private void movePenUp(int length){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  length; i++){
            board[posX - i][posY] = coloredCellChar;
            penPosition.setX(posX - i);
        }
        out.println("Position: (" + penPosition.getX() + "." + penPosition.getY() + ")" );
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    private void movePenRight(int length){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  length; j++){
            board[posX][posY + j] = coloredCellChar;
            penPosition.setY(posY + j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
        out.println("Position: (" + penPosition.getX() + "." + penPosition.getY() + ")" );
    }
    private void movePenLeft(int length){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  length; j++){
            board[posX][posY - j] = coloredCellChar;
            penPosition.setY(posY - j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
        out.println("(" + penPosition.getX() + "." + penPosition.getY() + ")" );
    }
    private void movePenDown(int length){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  length; i++){
            board[posX + i][posY] = coloredCellChar;
            penPosition.setX(posX + i);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
        out.println("Position: (" + penPosition.getX() + "." + penPosition.getY() + ")" );
    }
    enum Direction{
        UP('u'),DOWN('d'),LEFT('l'),RIGHT('r');
        public char code;
        Direction(char code){this.code = code;}
    }
}
