import java.util.Scanner;
import java.util.InputMismatchException;

public class DeckOfCards {

    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        return deck;
    }

    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    public static String[][] distributeCards(String[] deck, int players, int cardsPerPlayer) {
        if (players * cardsPerPlayer > deck.length) {
            throw new IllegalArgumentException("Not enough cards in the deck");
        }

        String[][] playerHands = new String[players][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < players; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerHands[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return playerHands;
    }

    public static void printHands(String[][] playerHands) {
        for (int i = 0; i < playerHands.length; i++) {
            System.out.println("Player " + (i + 1) + " hand:");
            for (int j = 0; j < playerHands[i].length; j++) {
                System.out.println(" - " + playerHands[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = 0;
        int cardsPerPlayer = 0;

        try {
            System.out.print("Enter number of players: ");
            players = scanner.nextInt();
            System.out.print("Enter number of cards per player: ");
            cardsPerPlayer = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format.");
            System.exit(1);
        }

        try {
            String[] deck = initializeDeck();
            deck = shuffleDeck(deck);
            String[][] hands = distributeCards(deck, players, cardsPerPlayer);
            printHands(hands);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
