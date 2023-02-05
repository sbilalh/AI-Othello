public class Board {

    // representation of board as 4x4 array
    public int[][] board;

    // representation of pieces
    static int BLACK = 1;
    static int WHITE = -1;
    static int EMPTY = 0;

    // setters and getters
    public Board(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return this.board;
    }

    // initialize the board
    void populateBoard() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                // 0's for empty positions
                this.board[i][j] = EMPTY;
                // b2 & c3 set to white (-1)
                if ((i == 1 && j == 1) || (i == 2 && j == 2)) {
                    this.board[i][j] = WHITE;
                }
                // b3 & c2 set to black (1)
                if ((i == 2 && j == 1) || (i == 1 && j == 2)) {
                    this.board[i][j] = BLACK;
                }
            }
        }
    }

    // check if the given move is legal
    boolean isLegal(int i, int j, int player) {
        // check if out of bounds
        if (i > 3 || j > 3 || i < 0 || j < 0) {
            return false;
        } 
        // check if position is empty
        else if (this.board[i][j] != EMPTY) {
            return false;
        }
        // check if given move allows captures
        else if (!canFlip(i, j, player, false)) {
            return false;
        }
        // else legal
        else {
            return true;
        }
    }

    boolean canFlip(int x, int y, int player, boolean flip) {
        // initialize return value
        boolean foundCapture = false;

        // figure out what color opponent is
        int opponent;
        if (player == BLACK) {
            opponent = WHITE;
        }
        else {
            opponent = BLACK;
        }

        // check all possible directions to see if its a valid move
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                // if at current location then skip
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int x2 = x + dx;
                int y2 = y + dy;

                // if adjacent tile is of opposite color then continue iterating until you hit your color
                if (x2 >= 0 && x2 < this.board.length && y2 >= 0 && y2 < this.board[0].length && this.board[x2][y2] == opponent) {
                    while (x2 >= 0 && x2 < this.board.length && y2 >= 0 && y2 < this.board[0].length && this.board[x2][y2] == opponent) {
                        x2 += dx;
                        y2 += dy;
                    }

                    // if you hit your own color then valid move
                    if (x2 >= 0 && x2 < this.board.length && y2 >= 0 && y2 < this.board[0].length && this.board[x2][y2] == player) {
                        foundCapture = true;
                        if (flip) {
                            x2 = x + dx;
                            y2 = y + dy;
                            while(this.board[x2][y2] == opponent) {
                                this.board[x2][y2] = player;
                                x2 += dx;
                                y2 += dy;
                            }
                        }
                    }
                }
            }
        }

        if (flip) {
            this.board[x][y] = player;
        }

        return foundCapture;
    }

    // place a piece given coordinates and color and update the board
    boolean updateBoard(int i, int j, int player) {
        // check if position is legal
        if (isLegal(i, j, player)) {
            // move is legal so place the piece and flip pieces by passing true as flip flag to canFlip
            canFlip(i, j, player, true);
            return true;
        }
        // if loop exited then piece could not be placed
        return false;
    }

}
