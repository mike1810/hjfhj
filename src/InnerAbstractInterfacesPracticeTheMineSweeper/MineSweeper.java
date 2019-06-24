package InnerAbstractInterfacesPracticeTheMineSweeper;

import static java.lang.System.*;

public class MineSweeper {

    private char[][] board;// user board

    private char[][] openedBoard;//user-hidden bombs board

    private Position penPosition;

    private int Bombs;

    private boolean youLose;

    private boolean youWin;

    private boolean[][] cellIsBomb;

    private boolean[][] cellIsOpened;

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
        //this.markedPenCellChar = 'Ж';
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
        cellIsOpened = new boolean[height][width];
        youLose = false;
        youWin = false;
        //openedBoard = new char[height][width];

        mineSweeperBoardInit();
        randomizeBomb();
        mineSweeperCellIsOpenedInit();
        mineSweeperOpenedBoardInit();
    }

    private void randomizeBomb(){
        this.cellIsBomb = new boolean[boardHeight][boardWidth];
        initializeBobmCells(this.cellIsBomb);

        do {
            int width = (int)(Math.random()*boardWidth);
            int height = (int)(Math.random()*boardHeight);
            cellIsBomb[height][width] = true;
        }
        while(checkInstalledBobmQuantity() < Bombs);
    }

    private void initializeBobmCells( boolean[][] bombBoard){
        for(int i = 0; i < boardHeight; i++)
            for(int j = 0; j < boardWidth; j++)
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
            for(int i = 0; i < boardHeight; i++) {
                for(int j = 0; j < boardWidth; j++) {
                    if(cellIsBomb[i][j]) installedBombs++;
                }
            }
            return installedBombs;
        }

    protected Position getPosition(){
        //out.println("MineSweeper position is: "+ (penPosition.getX() + 1) + " column, " + (penPosition.getY() + 1) + " row.");
        return penPosition;
    }

    private void mineSweeperBoardInit(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = closedChar;
            }
        }
    }

    private void mineSweeperCellIsOpenedInit(){
        for(int i = 0; i < boardWidth; i++)
            for (int j = 0; j < boardHeight; j++) {
                cellIsOpened[j][i] = false;
            }
    }

    private void mineSweeperOpenedBoardInit(){
        openedBoard = new char [boardHeight][boardWidth];
        for(int h = 0; h < openedBoard.length; h++){
            for(int w = 0; w < openedBoard[h].length; w++){
                openedBoard[h][w] = checkBombs(cellIsBomb, h, w);
            }
        }
    }

    public void printCellIsBomb() {

        for (boolean[] bombBoardLine : cellIsBomb) {
            for (boolean bombCell : bombBoardLine) {
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }
    }

    public void printCellIsOpened() {

        for (boolean[] bombBoardLine : cellIsOpened) {
            for (boolean bombCell : bombBoardLine) {
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }
    }

    public void printOpenedBoard() {

        for (char[] openedBombBoardLine : openedBoard) {
            for (char bombCell : openedBombBoardLine) {
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }
    }

    void clearBoard(){
        penPosition.setX(0);
        penPosition.setY(0);
        mineSweeperBoardInit();
    }

    void showBoard(){

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
            {
                if (i == penPosition.getY()  && j == penPosition.getX()) {
                    out.print("<" + board[i][j] + ">");
                } else {
                    out.print(" " + board[i][j] + " ");
                }
            }
            out.println( );
        }

   /*     for (char[] chars : board) {
            for (char aChar : chars) {
                out.print(aChar + " ");
            }
            out.println( );
        }*/
    }

    void penCheckBomb(Position a){
        int posY = penPosition.getY();
        int posX = penPosition.getX();

        if(openedBoard[posY][posX] != '0' && openedBoard[posY][posX] != '@'){
            board[posY][posX] = openedBoard[posY][posX];
            cellIsOpened[posY][posX] = true;
        }
        if(openedBoard[posY][posX] == '@'){
            board[posY][posX] = '@';
            cellIsOpened[posY][posX] = true;
            youLose = true;
            for(int i = 0; i < boardHeight; i++){
                for(int j = 0; j < boardWidth; j++){
                    if(board[posY][posX] == 'X'){
                        board[posY][posX] = '*';
                    }
                    if(openedBoard[posY][posX] == '@'){
                        board[posY][posX] = '@';
                    }
                }
            }
        }
        if(openedBoard[posY][posX] == '0'){
            board[posY][posX] = ' ';
            cellIsOpened[posY][posX] = true;

            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1 && cellIsOpened[posY-1][posX-1] == false){
                //penCheckBomb(new Position(posY - 1,posX - 1));
                if(openedBoard[posY - 1][posX - 1] != '0' && openedBoard[posY - 1][posX - 1] != '@'){
                    board[posY - 1][posX - 1] = openedBoard[posY - 1][posX - 1];
                    cellIsOpened[posY - 1][posX - 1] = true;

                }
                if(openedBoard[posY - 1][posX - 1] == '0'){
                    board[posY - 1][posX - 1] = ' ';
                    cellIsOpened[posY - 1][posX - 1] = true;
                    penCheckBomb(new Position(posX - 1, posY - 1));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY+1][posX-1] == false){
                //penCheckBomb(new Position(posY + 1,posX - 1));
                if(openedBoard[posY + 1][posX - 1] != '0' && openedBoard[posY + 1][posX - 1] != '@'){
                    board[posY + 1][posX - 1] = openedBoard[posY + 1][posX - 1];
                    cellIsOpened[posY + 1][posX - 1] = true;
                }
                if(openedBoard[posY + 1][posX - 1] == '0'){
                    board[posY + 1][posX - 1] = ' ';
                    cellIsOpened[posY + 1][posX - 1] = true;
                    penCheckBomb(new Position(posX - 1, posY + 1));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY][posX-1] == false){
                //penCheckBomb(new Position(posY,posX - 1));
                if(openedBoard[posY][posX - 1] != '0' && openedBoard[posY][posX - 1] != '@'){
                    board[posY][posX - 1] = openedBoard[posY][posX - 1];
                    cellIsOpened[posY][posX - 1] = true;
                }
                if(openedBoard[posY][posX - 1] == '0'){
                    board[posY][posX - 1] = ' ';
                    cellIsOpened[posY][posX - 1] = true;
                    penCheckBomb(new Position(posX - 1, posY));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY-1][posX+1] == false){
                //penCheckBomb(new Position(posY - 1,posX + 1));
                if(openedBoard[posY - 1][posX + 1] != '0' && openedBoard[posY - 1][posX + 1] != '@'){
                    board[posY - 1][posX - 1] = openedBoard[posY - 1][posX + 1];
                    cellIsOpened[posY - 1][posX + 1] = true;
                }
                if(openedBoard[posY - 1][posX + 1] == '0'){
                    board[posY - 1][posX + 1] = ' ';
                    cellIsOpened[posY - 1][posX + 1] = true;
                    penCheckBomb(new Position(posX + 1, posY - 1));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY+1][posX+1] == false){
                //penCheckBomb(new Position(posY + 1,posX + 1));
                if(openedBoard[posY + 1][posX + 1] != '0' && openedBoard[posY + 1][posX + 1] != '@'){
                    board[posY + 1][posX + 1] = openedBoard[posY + 1][posX + 1];
                    cellIsOpened[posY + 1][posX + 1] = true;
                }
                if(openedBoard[posY + 1][posX + 1] == '0'){
                    board[posY + 1][posX + 1] = ' ';
                    cellIsOpened[posY + 1][posX + 1] = true;
                    penCheckBomb(new Position(posX + 1, posY + 1));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY][posX+1] == false){
                //penCheckBomb(new Position(posY,posX + 1));
                if(openedBoard[posY][posX + 1] != '0' && openedBoard[posY][posX + 1] != '@'){
                    board[posY][posX + 1] = openedBoard[posY][posX + 1];
                    cellIsOpened[posY][posX + 1] = true;
                }
                if(openedBoard[posY][posX + 1] == '0'){
                    board[posY][posX + 1] = ' ';
                    cellIsOpened[posY][posX + 1] = true;
                    penCheckBomb(new Position( posX + 1, posY));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY - 1][posX] == false){
                //penCheckBomb(new Position(posY - 1,posX));
                if(openedBoard[posY - 1][posX] != '0' && openedBoard[posY - 1][posX] != '@'){
                    board[posY - 1][posX] = openedBoard[posY - 1][posX];
                    cellIsOpened[posY - 1][posX] = true;
                }
                if(openedBoard[posY - 1][posX] == '0'){
                    board[posY - 1][posX] = ' ';
                    cellIsOpened[posY - 1][posX] = true;
                    penCheckBomb(new Position( posX, posY - 1));
                }
            }
            if(posY > 0 && posY < boardWidth - 1 && posX > 0 && posX < boardHeight - 1&& cellIsOpened[posY + 1][posX] == false){
                //penCheckBomb(new Position(posY + 1,posX));
                if(openedBoard[posY + 1][posX] != '0' && openedBoard[posY + 1][posX] != '@'){
                    board[posY + 1][posX] = openedBoard[posY + 1][posX];
                    cellIsOpened[posY + 1][posX ] = true;
                }
                if(openedBoard[posY + 1][posX] == '0'){
                    board[posY + 1][posX] = ' ';
                    cellIsOpened[posY + 1][posX] = true;
                    penCheckBomb(new Position(posX, posY + 1));
                }
            }
        }
    }

    void penCheckBomb2(Position a){
        int posY = penPosition.getY();
        int posX = penPosition.getX();

        if(openedBoard[posY][posX] != '0' && openedBoard[posY][posX] != '@'){
            board[posY][posX] = openedBoard[posY][posX];
            cellIsOpened[posY][posX] = true;
            return;
        }

        if(openedBoard[posY][posX] == '@'){
            board[posY][posX] = '@';
            cellIsOpened[posY][posX] = true;
            youLose = true;
            for(int i = 0; i < boardHeight; i++){
                for(int j = 0; j < boardWidth; j++){
                    if(board[posY][posX] == 'X'){
                        board[posY][posX] = '*';
                    }
                    if(openedBoard[posY][posX] == '@'){
                        board[posY][posX] = '@';
                    }
                }
            }
            return;
        }

        if(openedBoard[posY][posX] == '0'){
            board[posY][posX] = ' ';
            cellIsOpened[posY][posX] = true;
            boolean flag = true;

               /* if( posY+1 < boardHeight && !cellIsOpened[posY+1][posX]){
                    penCheckBomb2(new Position(posX, posY+1));
                }
                if( posY+1 < boardHeight && posX + 1 < boardWidth && !cellIsOpened[posY+1][posX+1]){
                    penCheckBomb2(new Position(posX+1, posY+1));
                }
                if( posX + 1 < boardWidth && !cellIsOpened[posY][posX+1]) {
                    penCheckBomb2(new Position(posX + 1, posY));
                }
                if( posY-1 < boardHeight && posX + 1 < boardWidth && !cellIsOpened[posY-1][posX+1]){
                penCheckBomb2(new Position(posX+1, posY-1));
                }
                if( posY + 1 < boardHeight && posX - 1 < boardWidth && !cellIsOpened[posY+1][posX-1]) {
                    penCheckBomb2(new Position(posX - 1, posY + 1));
                }
                if( posX - 1 < boardWidth && !cellIsOpened[posY][posX-1]) {
                    penCheckBomb2(new Position(posX - 1, posY));
                }
                if(posY-1 < boardHeight && posX - 1 < boardWidth && !cellIsOpened[posY-1][posX-1]){
                    penCheckBomb2(new Position(posX-1, posY-1));
                }
                if(posY-1 < boardHeight && !cellIsOpened[posY-1][posX]) {
                    penCheckBomb2(new Position(posX, posY - 1));
                }*/
        }
        penCheckBomb2(new Position(posX, posY+1));
        penCheckBomb2(new Position(posX+1, posY+1));
        penCheckBomb2(new Position(posX + 1, posY));
        penCheckBomb2(new Position(posX+1, posY-1));
        penCheckBomb2(new Position(posX - 1, posY + 1));
        penCheckBomb2(new Position(posX - 1, posY));
        penCheckBomb2(new Position(posX-1, posY-1));
        penCheckBomb2(new Position(posX, posY - 1));

        return;
    }

    public boolean getYouLose(){
        return youLose;
    }

    public boolean getYouWin(){
        youWin = true;
        for(int i = 0; i < boardHeight; i++){
            for(int j = 0; j < boardWidth; j++){
                if(cellIsOpened[i][j] == cellIsBomb[i][j]){
                    youWin = false;
                }
            }
        }
        return youWin;
    }

    void penMarkBomb(){
        board[penPosition.getY()][penPosition.getX()] = markedCellChar;
    }

    void moveLeft(){
        if(penPosition.getX() > 0){
            penPosition.setX(penPosition.getX() - 1);
        }
    }

    void moveRight(){
        if(penPosition.getX() < boardWidth - 1){
            penPosition.setX(penPosition.getX() + 1);
        }
    }

    void moveUp(){
        if(penPosition.getY() > 0) {
            penPosition.setY(penPosition.getY() - 1);
        }
    }

    void moveDown(){
            if(penPosition.getY() < boardHeight - 1) {
                penPosition.setY(penPosition.getY() + 1);
            }
    }
}