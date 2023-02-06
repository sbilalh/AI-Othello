public abstract class Player {
    int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public abstract Move getMove(Board board);
}
