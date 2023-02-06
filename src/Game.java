import java.util.ArrayList;

public class Game {
    
    int winnerValue;
    
    
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
    
    
    private static int winnerValue {
        int answer = 0;
		//traverse the 2D board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				//add answer only if we identify the tile is the same
				if (board[i][j] == a)
					answer++;
			}
		}
	    
		return answer;
        
    }

	
    public static void main(String[] args) {
        play();
    }
}
