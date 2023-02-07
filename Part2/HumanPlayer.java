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
            case "a5":
                move = new Move(4, 0);
                break;
            case "a6":
                move = new Move(5, 0);
                break;
            case "a7":
                move = new Move(6, 0);
                break;
            case "a8":
                move = new Move(7, 0);
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
            case "b5":
                move = new Move(4, 1);
                break;
            case "b6":
                move = new Move(5, 1);
                break;
            case "b7":
                move = new Move(6, 1);
                break;
            case "b8":
                move = new Move(7, 1);
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
            case "c5":
                move = new Move(4, 2);
                break;
            case "c6":
                move = new Move(5, 2);
                break;
            case "c7":
                move = new Move(6, 2);
                break;
            case "c8":
                move = new Move(7, 2);
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
            case "d5":
                move = new Move(4, 3);
                break;
            case "d6":
                move = new Move(5, 3);
                break;
            case "d7":
                move = new Move(6, 3);
                break;
            case "d8":
                move = new Move(7, 3);
                break;
            case "e1":
                move = new Move(0, 4);
                break;
            case "e2":
                move = new Move(1, 4);
                break;
            case "e3":
                move = new Move(2, 4);
                break;
            case "e4":
                move = new Move(3, 4);
                break;
            case "e5":
                move = new Move(4, 4);
                break;
            case "e6":
                move = new Move(5, 4);
                break;
            case "e7":
                move = new Move(6, 4);
                break;
            case "e8":
                move = new Move(7, 4);
                break;
            case "f1":
                move = new Move(0, 5);
                break;
            case "f2":
                move = new Move(1, 5);
                break;
            case "f3":
                move = new Move(2, 5);
                break;
            case "f4":
                move = new Move(3, 5);
                break;
            case "f5":
                move = new Move(4, 5);
                break;
            case "f6":
                move = new Move(5, 5);
                break;
            case "f7":
                move = new Move(6, 5);
                break;
            case "f8":
                move = new Move(7, 5);
                break;
            case "g1":
                move = new Move(0, 6);
                break;
            case "g2":
                move = new Move(1, 6);
                break;
            case "g3":
                move = new Move(2, 6);
                break;
            case "g4":
                move = new Move(3, 6);
                break;
            case "g5":
                move = new Move(4, 6);
                break;
            case "g6":
                move = new Move(5, 6);
                break;
            case "g7":
                move = new Move(6, 6);
                break;
            case "g8":
                move = new Move(7, 6);
                break;
            case "h1":
                move = new Move(0, 7);
                break;
            case "h2":
                move = new Move(1, 7);
                break;
            case "h3":
                move = new Move(2, 7);
                break;
            case "h4":
                move = new Move(3, 7);
                break;
            case "h5":
                move = new Move(4, 7);
                break;
            case "h6":
                move = new Move(5, 7);
                break;
            case "h7":
                move = new Move(6, 7);
                break;
            case "h8":
                move = new Move(7, 7);
                break;
            default:
                move = new Move(-1, -1);
                break;
        }
        return move;
    }
}
