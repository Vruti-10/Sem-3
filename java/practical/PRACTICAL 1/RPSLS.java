import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    static int winner(Move a, Move b) {

        return switch (a) {
            case ROCK -> switch (b) {
                case SCISSORS, LIZARD -> 1;
                case ROCK -> 0;
                default -> -1;
            };

            case PAPER -> switch (b) {
                case ROCK, SPOCK -> 1;
                case PAPER -> 0;
                default -> -1;
            };

            case SCISSORS -> switch (b) {
                case PAPER, LIZARD -> 1;
                case SCISSORS -> 0;
                default -> -1;
            };

            case LIZARD -> switch (b) {
                case SPOCK, PAPER -> 1;
                case LIZARD -> 0;
                default -> -1;
            };

            case SPOCK -> switch (b) {
                case SCISSORS, ROCK -> 1;
                case SPOCK -> 0;
                default -> -1;
            };
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        Move[] moves = Move.values();

        for (int round = 1; round <= 5; round++) {

            Move computer = moves[random.nextInt(moves.length)];

            System.out.print("Your move: ");
            Move player = Move.valueOf(sc.next().toUpperCase());

            int result = winner(player, computer);

            System.out.println("You: " + player);
            System.out.println("Computer: " + computer);

            if (result == 1) {
                System.out.println("You win!");
                playerScore++;
            }
            else if (result == -1) {
                System.out.println("Computer wins!");
                computerScore++;
            }
            else {
                System.out.println("Tie!");
            }
        }

        System.out.println("Score: " + playerScore + "-" + computerScore);

        if (playerScore > computerScore)
            System.out.println("You win!");
        else if (computerScore > playerScore)
            System.out.println("Computer wins!");
        else
            System.out.println("Draw!");

        sc.close();
    }
}
