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
        if (bestMove != null) {
            String moveString = bestMove.toString();
            String aiMove = parseMove(moveString);
            System.out.println("AI move: " + aiMove);
        }
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
            case "(4,0)":
                move = "a5";
                break;
            case "(5,0)":
                move = "a6";
                break;
            case "(6,0)":
                move = "a7";
                break;
            case "(7,0)":
                move = "a8";
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
            case "(4,1)":
                move = "b5";
                break;
            case "(5,1)":
                move = "b6";
                break;
            case "(6,1)":
                move = "b7";
                break;
            case "(7,1)":
                move = "b8";
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
            case "(4,2)":
                move = "c5";
                break;
            case "(5,2)":
                move = "c6";
                break;
            case "(6,2)":
                move = "c7";
                break;
            case "(7,2)":
                move = "c8";
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
            case "(4,3)":
                move = "d5";
                break;
            case "(5,3)":
                move = "d6";
                break;
            case "(6,3)":
                move = "d7";
                break;
            case "(7,3)":
                move = "d8";
                break;
            case "(0,4)":
                move = "e1";
                break;
            case "(1,4)":
                move = "e2";
                break;
            case "(2,4)":
                move = "e3";
                break;
            case "(3,4)":
                move = "e4";
                break;
            case "(4,4)":
                move = "e5";
                break;
            case "(5,4)":
                move = "e6";
                break;
            case "(6,4)":
                move = "e7";
                break;
            case "(7,4)":
                move = "e8";
                break;
            case "(0,5)":
                move = "f1";
                break;
            case "(1,5)":
                move = "f2";
                break;
            case "(2,5)":
                move = "f3";
                break;
            case "(3,5)":
                move = "f4";
                break;
            case "(4,5)":
                move = "f5";
                break;
            case "(5,5)":
                move = "f6";
                break;
            case "(6,5)":
                move = "f7";
                break;
            case "(7,5)":
                move = "f8";
                break;
            case "(0,6)":
                move = "g1";
                break;
            case "(1,6)":
                move = "g2";
                break;
            case "(2,6)":
                move = "g3";
                break;
            case "(3,6)":
                move = "g4";
                break;
            case "(4,6)":
                move = "g5";
                break;
            case "(5,6)":
                move = "g6";
                break;
            case "(6,6)":
                move = "g7";
                break;
            case "(7,6)":
                move = "g8";
                break;
            case "(0,7)":
                move = "h1";
                break;
            case "(1,7)":
                move = "h2";
                break;
            case "(2,7)":
                move = "h3";
                break;
            case "(3,7)":
                move = "h4";
                break;
            case "(4,7)":
                move = "h5";
                break;
            case "(5,7)":
                move = "h6";
                break;
            case "(6,7)":
                move = "h7";
                break;
            case "(7,7)":
                move = "h8";
                break;
            default:
                move = "";
                break;
        }
        return move;
    }
}