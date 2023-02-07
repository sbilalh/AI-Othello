public class Move {
    int x;
    int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
