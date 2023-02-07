import java.util.*;

public class Game {

    public Game() {
    }

    void play() {
        // initializing board and passing it to Board class to create new board object
        int[][] board = new int[4][4];
        Board gameBoard = new Board(board);
        gameBoard.populateBoard();

        // boolean for skipping your turn if no legal move
        boolean skip = false;

        // printing introduction message and asking user for their choice of color
        System.out.println("------------------------------");
        System.out.println("  Reversi by Bilal & Steve!");
        System.out.println("------------------------------");
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to play DARK (X) or LIGHT (O)?");
        String choice = s.next();

        // printing the initial board
        System.out.println("------------------------------");
        System.out.println("            START");
        System.out.println("------------------------------");
        printBoard(gameBoard.getBoard());

        // game loop while game is not over
        while (!gameBoard.isGameOver()) {

            // if human picks black then enter if condition for that case
            if (choice.equals("x")) {

                // if no more valid moves for black then print that message and break from game
                // loop
                if (gameBoard.getValidMoves(1).size() == 0) {
                    System.out.println("No valid moves for black.");
                    skip = true;
                }

                if (!skip) {
                    // create new human player object and get humans move
                    HumanPlayer human = new HumanPlayer(1);
                    Move first = human.getMove(gameBoard);

                    // update the board, if cannot update board then enter the loop
                    if (!gameBoard.updateBoard(first, 1)) {
                        // black entered invalid move, prompt to try again
                        System.out.println("Invalid move, try again.");
                        continue;
                    }
                    // print board after blacks turn
                    printBoard(gameBoard.getBoard());
                }

                // reset skip
                skip = false;

                // create new ai player object and get ai's move
                AIPlayer ai = new AIPlayer(2);
                Move second = ai.getMove(gameBoard);

                // if no more valid moves for white then print that message and break from game
                // loop
                if (second == null) {
                    System.out.println("No valid moves for white.");
                    continue;
                }

                // update the board
                gameBoard.updateBoard(second, 2);
                // print the board after whites turn
                printBoard(gameBoard.getBoard());
            }
            
            // if human picks white then enter if condition for that case
            else {

                // create new ai player object and get ai's move
                AIPlayer ai = new AIPlayer(1);
                Move first = ai.getMove(gameBoard);

                // if no more valid moves for black then print that message and break from game
                // loop
                if (first == null) {
                    System.out.println("No valid moves for black.");
                    skip = true;
                }

                if (!skip) {
                    // update the board
                    gameBoard.updateBoard(first, 1);
                    // print the board after blacks turn
                    printBoard(gameBoard.getBoard());
                }

                // reset skip
                skip = false;

                // if no more valid moves for white then print that message and break from game
                // loop
                if (gameBoard.getValidMoves(2).size() == 0) {
                    System.out.println("No valid moves for white.");
                    continue;
                }

                // create new human player object and get humans move
                HumanPlayer human = new HumanPlayer(2);
                Move second = human.getMove(gameBoard);

                // update the board, if cannot update board then enter the loop
                if (!gameBoard.updateBoard(second, 2)) {
                    // white entered invalid move, prompt to try again
                    System.out.println("Invalid move, try again.");
                    continue;
                }
                // print board after whites turn
                printBoard(gameBoard.getBoard());

            }
        }

        gameBoard.checkWinner();
    }

    // method to print the board
    void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            // print column numbers
            if (i == 0) {
                System.out.println("   a b c d");
                System.out.println("  ---------");
            }
            // print row numbers
            int row = i + 1;
            System.out.print(row + "| ");
            // print board
            for (int j = 0; j < board[0].length; j++) {
                // black is 'x'
                if (board[i][j] == 1) {
                    System.out.print("x ");
                }
                // white is 'o'
                else if (board[i][j] == 2) {
                    System.out.print("o ");
                }
                // empty is '-'
                else {
                    System.out.print("- ");
                }

            }
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.play();
    }
}
