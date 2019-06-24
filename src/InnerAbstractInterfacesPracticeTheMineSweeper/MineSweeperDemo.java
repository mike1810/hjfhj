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
        MineSweeper mineSweeper;
        mineSweeper = mineSweeperBoardInit();
        //mineSweeper.printCellIsBomb();
        //mineSweeper.printOpenedBoard();
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

        boolean userLearned = true;
        while(true){
            mineSweeper.showBoard();
            out.println("Move : w(up), s(down), a(left), d(right), c(for clear board)");
            moveOptionScan = scan.next();
            char direction = moveOptionScan.charAt(0);
            switch(direction){
                case 'w': mineSweeper.movePen(MineSweeper.Direction.UP); break;
                case 's': mineSweeper.movePen(MineSweeper.Direction.DOWN); break;
                case 'a': mineSweeper.movePen(MineSweeper.Direction.LEFT); break;
                case 'd': mineSweeper.movePen(MineSweeper.Direction.RIGHT); break;
                case 'm': mineSweeper.penMarkBomb(); break;
                case ' ': mineSweeper.penCheckBomb(); break;
                case 'c': mineSweeper.clearBoard();  break;
                default:
                    out.println("You don`t move like this: " + moveOptionScan);
            }
            userLearned = true;
        }
    }

    public static int getMoveSteps(){
        Scanner scan = new Scanner(in);
        int moveSteps;
        out.println("Enter the number of steps ");
        String checkEmptyStepValue = scan.nextLine();
        if(checkEmptyStepValue.equals("")){
            return 0;
        }
        moveSteps = Integer.parseInt(checkEmptyStepValue);
        if(moveSteps < 0){
            out.println("Number of steps can`t be less than 0. You don`t move");
            moveSteps = 0;
            return moveSteps;
        }
        return moveSteps;
    }
}