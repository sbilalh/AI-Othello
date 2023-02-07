import java.util.*;

public class AIPlayer extends Player {

    public Move bestMove;

    public AIPlayer(int playerNumber) {
        super(playerNumber);
    }

    @Override
    // creates a copy of the board and calls minmax on that cpy with a depth of 10
    public Move getMove(Board board) {
        Board copy = new Board(board.copyBoard());
        minmax(copy, getPlayerNumber());
        String moveString = bestMove.toString();
        String aiMove = parseMove(moveString);
        System.out.println("AI move: " + aiMove);
        return bestMove;
    }

    // minmax algorithm
    private int minmax(Board board, int player) {
        // returns 0 if depth limit is reached or the game is over
        if (board.isGameOver()) {
            return 0;
        }

        // initializes bestScore to a min value if the current player is AI, else to max
        // value
        int bestScore = (player == playerNumber) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        // gets all the valid moves for the current player
        List<Move> moves = board.getValidMoves(player);
        // loops through all the moves for that state of the game
        for (Move move : moves) {
            // update the board for that move
            board.updateBoard(move, player);
            // recursively call minmax
            int score = minmax(board, 3 - player);

            // if current player is AI then set best score to the maximum of bestScore and
            // the opponents score
            if (player == playerNumber) {
                bestScore = Math.max(bestScore, score);
                this.bestMove = move;
            }
            // else set it equal to the minimum of bestScore and opponents score
            else {
                bestScore = Math.min(bestScore, score);
                this.bestMove = move;
            }
        }

        return bestScore;
    }

    public String parseMove(String aiMove) {
        String move;
        switch (aiMove) {
            case "(0,0)":
                move = "a1";
                break;
            case "(1,0)":
                move = "a2";
                break;
            case "(2,0)":
                move = "a3";
                break;
            case "(3,0)":
                move = "a4";
                break;
            case "(0,1)":
                move = "b1";
                break;
            case "(1,1)":
                move = "b2";
                break;
            case "(2,1)":
                move = "b3";
                break;
            case "(3,1)":
                move = "b4";
                break;
            case "(0,2)":
                move = "c1";
                break;
            case "(1,2)":
                move = "c2";
                break;
            case "(2,2)":
                move = "c3";
                break;
            case "(3,2)":
                move = "c4";
                break;
            case "(0,3)":
                move = "d1";
                break;
            case "(1,3)":
                move = "d2";
                break;
            case "(2,3)":
                move = "d3";
                break;
            case "(3,3)":
                move = "d4";
                break;
            default:
                move = "";
                break;
        }
        return move;
    }
}