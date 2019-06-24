package InnerAbstractInterfacesPracticeTheMineSweeper;

import java.util.Scanner;
import static java.lang.System.*;

public class MineSweeperDemo {

    static final int EASY_WIDTH = 9;
    static final int EASY_HEIGHT = 9;
    static final int EASY_BOMBS = 9;
    static final int MEDIUM_WIDTH = 16;
    static final int MEDIUM_HEIGHT = 16;
    static final int MEDIUM_BOMBS = 40;
    static final int HARD_WIDTH = 30;
    static final int HARD_HEIGHT = 16;
    static final int HARD_BOMBS = 100;

    public static void main(String[] args) {
        mineSweeperGame();
    }

    public static void mineSweeperGame(){
        MineSweeper mineSweeper;
        mineSweeper = mineSweeperBoardInit();
        //mineSweeper.printCellIsBomb();
        mineSweeper.printOpenedBoard();
        playMineSweeper(mineSweeper);
    }


    public static MineSweeper mineSweeperBoardInit(){

        int width = EASY_WIDTH,
                    height = EASY_HEIGHT,
                    bombs = EASY_BOMBS,
                    userPenPositionX = 0,
                    userPenPositionY = 0;

        Scanner scan = new Scanner(in);

        out.println("Enter game difficulty(1 or 2 or 3):" +
                "\n1) easy" +
                "\n2) medium" +
                "\n3) hard");

        int difficulty = 1;

        try {
            String userDifficulty = scan.next();
            difficulty = Integer.parseInt(userDifficulty);
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid difficulty value");
        }

        if(difficulty == 1){
            width = EASY_WIDTH; height = EASY_HEIGHT; bombs = EASY_BOMBS;
        }
        if(difficulty == 2){
            width = MEDIUM_WIDTH; height = MEDIUM_HEIGHT; bombs = MEDIUM_BOMBS;
        }
        if(difficulty == 3){
            width = HARD_WIDTH; height = HARD_HEIGHT; bombs = HARD_BOMBS;
        }

        MineSweeper mineSweeper = new MineSweeper(height, width, bombs);
        return mineSweeper;
    }

    public static void playMineSweeper( MineSweeper mineSweeper){
        Scanner scan = new Scanner(in);
        String moveOptionScan;

        boolean youlose = false;
        while(!youlose){
            if(mineSweeper.getYouLose()){
                mineSweeper.showBoard();
                out.println("You Lose");
                youlose = mineSweeper.getYouLose();
                mineSweeperGame();
            }
            else{
                mineSweeper.showBoard();
                //mineSweeper.getPosition();
                out.println("Move : w(up), s(down), a(left), d(right), c(for clear board)");
                moveOptionScan = scan.next();
                char direction = moveOptionScan.charAt(0);
                switch(direction){
                    case 'w': mineSweeper.moveUp(); break;
                    case 'a': mineSweeper.moveLeft(); break;
                    case 'd': mineSweeper.moveRight(); break;
                    case 's': mineSweeper.moveDown(); break;
                    case 'r': mineSweeper.penMarkBomb(); break;
                    case 'e': mineSweeper.penCheckBomb(mineSweeper.getPosition()); break;
                    case 'x': mineSweeper.clearBoard();  break;
                    default:
                        out.println("You don`t move like this: " + moveOptionScan);
                }
            }
        }
    }

}