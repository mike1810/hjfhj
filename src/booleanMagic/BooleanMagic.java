package booleanMagic;

public class BooleanMagic {
    static final int  Width = 15, Height = 10, Bombs = 30;
    public static void main(String[] args){

        boolean[][] bombBoard = new boolean[Height][Width];
        initializeBobmCells(bombBoard);
        printBoolean(bombBoard);

        do {
            int xBomb = (int)(Math.random()*(Height));
            int yBomb = (int)(Math.random()*(Width));
            System.out.println("BombLine = " + (xBomb+1) + " BombCol = " + (yBomb+1));
            bombBoard[xBomb][yBomb] = true;
            System.out.println(checkInstalledBobmQuantity(bombBoard));
        }
        while(checkInstalledBobmQuantity(bombBoard) < Bombs);
        printBoolean(bombBoard);

        char[][] openedBoard = new char[Height][Width];
        for(int h = 0; h < Height; h++){
            for(int w = 0; w < Width; w++){
                openedBoard[h][w] = checkBombs(bombBoard, h, w);
            }
        }
        printChar(openedBoard);

        for(int i = 0; i < Height; i++){
            for(int j = 0; j < Width; j++)
            {
                if(openedBoard[i][j] == ' '){
                    openedBoard[i][j] = '0';
                }
            }
        }
        printChar(openedBoard);
        System.out.println();


        for(int i = 0; i < Height; i++){
            for(int j = 0; j < Width; j++)
            {
                if(openedBoard[i][j] == '0'){
                    replace(openedBoard, i, j);
                }
            }
        }
        printChar(openedBoard);
    }

    private static void replace(char[][] openedBoard ,int i, int j){
        if(openedBoard[i][j] == '0'){
            openedBoard[i][j] = ' ';
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i - 1,j - 1);}
            if(i-1 > 0 ) {replace(openedBoard, i - 1,j);}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i - 1,j + 1);}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i + 1,j - 1);}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i + 1,j );}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i + 1,j + 1);}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i ,j - 1);}
            if(i-1 > 0 && j - 1 > 0) {replace(openedBoard, i ,j + 1);}
        }
    }

    private static char checkBombs(boolean [][] bombBoard, int hCell, int wCell) {
        int fromHeight = (hCell == 0) ? hCell : hCell - 1;
        int toHeight = (hCell == Height - 1) ? hCell : hCell + 1;
        int fromWidth = (wCell == 0) ? wCell : wCell - 1;
        int toWidth = (wCell == Width - 1) ? wCell : wCell + 1;

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
        return ' ';
    }

    private static void initializeBobmCells( boolean[][] bombBoard){
        for(int i = 0; i < bombBoard.length; i++)
            for(int j = 0; j < bombBoard[i].length; j++)
                bombBoard[i][j] = false;
    }


    private static int checkInstalledBobmQuantity(boolean[][] bombBoard){
        int installedBombs = 0;
        for(int i = 0; i < bombBoard.length; i++) {
            for(int j = 0; j < bombBoard[i].length; j++) {
                if(bombBoard[i][j] == true) installedBombs++;
            }
        }
        return installedBombs;
    }

    public static void printBoolean(boolean[][] bombBoard) {
        for (boolean[] bombBoardLine : bombBoard) {
            for (boolean bombCell : bombBoardLine) {
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }
    }
    public static void printChar(char[][] openedBombBoard) {
        for (char[] openedBombBoardLine : openedBombBoard) {
            for (char bombCell : openedBombBoardLine) {
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }
    }
    private static void recursiveOpen(char[][] openedBombBoard, int hCell, int wCell) {
        int fromHeight = (hCell == 0) ? hCell : hCell - 1;
        int toHeight = (hCell == Height - 1) ? hCell : hCell + 1;
        int fromWidth = (wCell == 0) ? wCell : wCell - 1;
        int toWidth = (wCell == Width - 1) ? wCell : wCell + 1;


       /* for (int h = fromHeight; h <= toHeight; h++){
            for (int w = fromWidth; w <= toWidth; w++) {
                if (openedBombBoard[hCell][wCell] == ' ') {
                    if(openedBombBoard[hCell][wCell]){}
                }
            }
        }

*/
       /* for (char[] openedBombBoardLine : openedBombBoard) {
            for (char bombCell : openedBombBoardLine) {
                if()
                System.out.print(bombCell + " ");
            }
            System.out.println();
        }*/
    }
}
