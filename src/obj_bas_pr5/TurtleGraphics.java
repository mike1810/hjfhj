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
    TurtleGraphics(int height, int width, int penPositionX, int penPositionY){
        this.penPosition = new Position(penPositionX, penPositionY);
        board = new char[height][width];
        turtleGraphicsBoardInit();
    }
    protected void getPosition(){
        out.println("Turtle position is: "+ penPosition.getX()+" column, " + penPosition.getY() + " row.");
    }
    protected void turtleGraphicsBoardInit(int height, int width, int penPositionX, int penPositionY){
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
    protected void movePen(Direction dir, int userSteps){
        int realSteps = userSteps;
        switch(dir.code){
            case 'u':
                realSteps = (this.penPosition.getX() - realSteps < 0) ? this.penPosition.getX() : realSteps;
                movePenUp(realSteps);
                break;
            case 'd':
                realSteps = (this.penPosition.getX() +  realSteps  >= board.length - 1) ?
                        (board.length - (this.penPosition.getX()+1)) : realSteps;
                movePenDown(realSteps);
                break;
            case 'l':
                realSteps = (this.penPosition.getY() - realSteps < 0) ? this.penPosition.getY() : realSteps;
                movePenLeft(realSteps);
                break;
            case 'r':
                realSteps = (this.penPosition.getY() +  realSteps  >= board[penPosition.getX()].length - 1) ?
                        (board[penPosition.getX()].length - (this.penPosition.getY()+1)) : realSteps;
                movePenRight(realSteps);
                break;
        }
        out.println((realSteps < userSteps)?
                ("Turtle was able to move only " + realSteps + " steps"):
                ("Turtle was moving " + realSteps + " steps"));
    }
    private void movePenUp(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  steps; i++){
            board[posX - i][posY] = coloredCellChar;
            penPosition.setX(posX - i);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    private void movePenRight(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  steps; j++){
            board[posX][posY + j] = coloredCellChar;
            penPosition.setY(posY + j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    private void movePenLeft(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  steps; j++){
            board[posX][posY - j] = coloredCellChar;
            penPosition.setY(posY - j);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    private void movePenDown(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  steps; i++){
            board[posX + i][posY] = coloredCellChar;
            penPosition.setX(posX + i);
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }
    enum Direction{
        UP('u'),DOWN('d'),LEFT('l'),RIGHT('r');
        public char code;
        Direction(char code){this.code = code;}
    }
}
