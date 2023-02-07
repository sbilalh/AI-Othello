import java.util.*;

public class HumanPlayer extends Player {

    public HumanPlayer(int playerNumber) {
        super(playerNumber);
    }

    @Override
    // gets users move via a scanner
    public Move getMove(Board board) {
        Scanner s = new Scanner(System.in);
        System.out.print("Your move: ");
        String playerMove = "";
        playerMove = s.nextLine();
        Move currentMove = parseMove(playerMove);
        return currentMove;
    }

    // parses users move
    public Move parseMove(String playerMove) {
        Move move;
        switch (playerMove) {
            case "a1":
                move = new Move(0, 0);
                break;
            case "a2":
                move = new Move(1, 0);
                break;
            case "a3":
                move = new Move(2, 0);
                break;
            case "a4":
                move = new Move(3, 0);
                break;
            case "b1":
                move = new Move(0, 1);
                break;
            case "b2":
                move = new Move(1, 1);
                break;
            case "b3":
                move = new Move(2, 1);
                break;
            case "b4":
                move = new Move(3, 1);
                break;
            case "c1":
                move = new Move(0, 2);
                break;
            case "c2":
                move = new Move(1, 2);
                break;
            case "c3":
                move = new Move(2, 2);
                break;
            case "c4":
                move = new Move(3, 2);
                break;
            case "d1":
                move = new Move(0, 3);
                break;
            case "d2":
                move = new Move(1, 3);
                break;
            case "d3":
                move = new Move(2, 3);
                break;
            case "d4":
                move = new Move(3, 3);
                break;
            default:
                move = new Move(-1, -1);
                break;
        }
        return move;
    }
}
