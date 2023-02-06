import java.util.ArrayList;

public class Game {
       
    
    static void play() {
        int[][] board = new int[4][4];
        Board gameBoard = new Board(board);
        gameBoard.populateBoard();
        printBoard(gameBoard.getBoard());
        System.out.println();
        gameBoard.updateBoard(1, 0, 1);
        printBoard(gameBoard.getBoard());
        System.out.println();
        gameBoard.updateBoard(0, 2, -1);
        printBoard(gameBoard.getBoard());
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("x ");
                }
                else if (board[i][j] == -1) {
                    System.out.print("o ");
                }
                else {
                    System.out.print("- ");
                }
                
            }
        }
    }
    

	
    public static void main(String[] args) {
        play();
    }
}
