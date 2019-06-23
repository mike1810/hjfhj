package InnerAbstractInterfacesPracticeTheMineSweeper;

import static java.lang.System.*;

public class MineSweeper {

    private char[][] board;// user board
    private char openedBoard[][];//user-hidden bombs board
    private Position penPosition;
    private int Bombs;

    private boolean cellIsBomb[][];
    private int boardWidth;
    private int boardHeight;
    private char closedChar;//'.'
    private char markedCellChar;//'X'
    private char markedPenCellChar;//'o'
    private char penChar;//'x'

    {
        this.penPosition = new Position(0,0);
        this.closedChar = '.';
        this.markedCellChar = 'X';
        this.penChar = 'I';
        this.markedPenCellChar = 'Ж';
        this.board = new char[MineSweeperDemo.EASY_WIDTH][MineSweeperDemo.EASY_HEIGHT];
        this.board = new char[MineSweeperDemo.EASY_WIDTH][MineSweeperDemo.EASY_HEIGHT];
        this.cellIsBomb = randomizeBomb();
        this.mineSweeperBoardInit();
    }

    MineSweeper(){
        mineSweeperBoardInit();
    }

    MineSweeper(int height, int width, int bombs){
        this.Bombs = bombs;
        this.boardWidth = width;
        this.boardHeight = height;
        this.penPosition = new Position(boardHeight/2, boardWidth/2);
        board = new char[height][width];
        openedBoard = new char[height][width];
        this.cellIsBomb = randomizeBomb();
        mineSweeperBoardInit();
    }

    private boolean[][] randomizeBomb(){
        boolean[][] bombBoard = new boolean[board[0].length][board.length];
        initializeBobmCells(bombBoard);

        do {
            int width = (int)(Math.random()*board.length);
            int height = (int)(Math.random()*board[0].length);
            bombBoard[width][height] = true;
        }
        while(checkInstalledBobmQuantity() < Bombs);

        return bombBoard;
    }

    private void initializeBobmCells( boolean[][] bombBoard){
        for(int i = 0; i < bombBoard.length; i++)
            for(int j = 0; j < bombBoard[i].length; j++)
                bombBoard[i][j] = false;
    }


    private char checkBombs(boolean [][] bombBoard, int hCell, int wCell) {
        int fromHeight = (hCell == 0) ? hCell : hCell - 1;
        int toHeight = (hCell == boardHeight - 1) ? hCell : hCell + 1;
        int fromWidth = (wCell == 0) ? wCell : wCell - 1;
        int toWidth = (wCell == boardWidth - 1) ? wCell : wCell + 1;

        if(bombBoard[hCell][wCell]){
            return '@';
        }

        int bombsNear = 0;
        for (int h = fromHeight; h <= toHeight; h++){
            for (int w = fromWidth; w <= toWidth; w++) {
                if (!bombBoard[hCell][wCell] && bombBoard[h][w]) {
                    bombsNear++;
                }
            }
        }

        if(bombsNear == 1){return '1';}
        if(bombsNear == 2){return '2';}
        if(bombsNear == 3){return '3';}
        if(bombsNear == 4){return '4';}
        if(bombsNear == 5){return '5';}
        if(bombsNear == 6){return '6';}
        if(bombsNear == 7){return '7';}
        if(bombsNear == 8){return '8';}
        return '0';
    }


    private int checkInstalledBobmQuantity(){
            int installedBombs = 0;
            for(int i = 0; i < cellIsBomb.length; i++) {
                for(int j = 0; j < cellIsBomb[i].length; j++) {
                    if(cellIsBomb[i][j] == true) installedBombs++;
                }
            }
            return installedBombs;
        }



    protected void getPosition(){
        out.println("Turtle position is: "+ penPosition.getX()+" column, " + penPosition.getY() + " row.");
    }

    protected void turtleGraphicsBoardInit(int height, int width, int penPositionX, int penPositionY){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = closedChar;
            }
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }

    private void mineSweeperBoardInit(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = closedChar;
            }
        }
        board[penPosition.getX()][penPosition.getY()] = penChar;
    }

    protected void clearBoard(){
        penPosition.setX(0);
        penPosition.setY(0);
        mineSweeperBoardInit();
    }

    protected void showBoard(){
        for (char[] chars : board) {
            for (char aChar : chars) {
                out.print(aChar + " ");
            }
            out.println( );
        }
    }

    protected void movePen(Direction dir){
        int realSteps = 1;//1 - only one step in any direction we can do
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
    }

    public void penCheckBomb(){
        int posY = penPosition.getY();
        int posX = penPosition.getX();



    }




    public void penMarkBomb(){
        board[penPosition.getX()][penPosition.getY()] = markedPenCellChar;
    }

    private void movePenUp(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  steps; i++){
            if(board[posX - i][posY] == closedChar){
                board[posX - i][posY] = penChar;
            }else{
                if(board[posX - i][posY] == markedCellChar){
                    board[posX - i][posY] = markedPenCellChar;
                }
            }
            if(board[posX][posY] == markedPenCellChar){
                board[posX][posY] = markedCellChar;
            }else{
                if( board[posX][posY] == penChar){
                    board[posX][posY] = closedChar;
                }
            }
            penPosition.setX(posX - i);
        }
    }

    private void movePenRight(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  steps; j++){
            if(board[posX][posY + j] == closedChar){
                board[posX][posY + j] = penChar;
            }else{
                if(board[posX][posY + j] == markedCellChar){
                    board[posX][posY + j] = markedPenCellChar;
                }
            }
            if(board[posX][posY] == markedPenCellChar){
                board[posX][posY] = markedCellChar;
            }else{
                if( board[posX][posY] == penChar){
                    board[posX][posY] = closedChar;
                }
            }
            penPosition.setY(posY + j);
        }
    }

    private void movePenLeft(int steps){
        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int j = 0; j <=  steps; j++){
            if(board[posX][posY - j] == closedChar){
                board[posX][posY - j] = penChar;
            }else{
                if(board[posX][posY - j] == markedCellChar){
                    board[posX][posY - j] = markedPenCellChar;
                }
            }
            if(board[posX][posY] == markedPenCellChar){
                board[posX][posY] = markedCellChar;
            }else{
                if( board[posX][posY] == penChar){
                    board[posX][posY] = closedChar;
                }
            }
            penPosition.setY(posY - j);
        }
    }

    private void movePenDown(int steps){

        int posY = penPosition.getY();
        int posX = penPosition.getX();
        for(int i = 0; i <=  steps; i++){
            if(board[posX + i][posY] == closedChar){
                board[posX + i][posY] = penChar;
            }else{
                if(board[posX + i][posY] == markedCellChar){
                    board[posX + i][posY] = markedPenCellChar;
                }
            }
            if(board[posX][posY] == markedPenCellChar){
                board[posX][posY] = markedCellChar;
            }else{
                if( board[posX][posY] == penChar){
                    board[posX][posY] = closedChar;
                }
            }
            penPosition.setX(posX + i);
        }
    }

    enum Direction{
        UP('u'),DOWN('d'),LEFT('l'),RIGHT('r');
        public char code;
        Direction(char code){this.code = code;}
    }
}