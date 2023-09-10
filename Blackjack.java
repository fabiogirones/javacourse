import java.util.Scanner;

public class Blackjack {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();

        int card1 = drawRandomCard();
        int card2 = drawRandomCard();

        System.out
                .println("\n You get a \n " + cardString(card1) + "\n and a \n" + cardString(card2));

        int total = Math.min(card1, 10) + Math.min(card2, 10);
        System.out.println("Your total is: " + total);

        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();

        int dealerTotal = Math.min(dealerCard1, 10) + Math.min(dealerCard2, 10);

        System.out.println(
                "The dealer shows \n" + cardString(dealerCard1) + "\nand has card facing down \n" + faceDown());
        System.out.println("\n The dealer's total is hidden");

        while (true) {
            String option = hitOrStay();

            if (option.equals("stay")) {
                break;
            }

            int newCard = drawRandomCard();
            total += Math.min(newCard, 10);

            System.out.println("\nYou got a\n" + cardString(newCard));
            System.out.println("Your total is " + total);

            if (total > 21) {
                System.out.println("Bust! Player loses");
                System.exit(0);
            }
        }

        System.out.println("\nDealer's turn");
        System.out.println(
                "\n The dealer's cards are \n " + cardString(dealerCard1) + "\n and a \n" + cardString(dealerCard2));

        System.out.println("\nDealer's total " + dealerTotal);

        while (dealerTotal < 17) {
            int newCard = drawRandomCard();

            dealerTotal += Math.min(newCard, 10);
            System.out.println("\n Dealer gets a \n" + cardString(newCard));
            System.out.println("\nDealer's total " + dealerTotal);
        }

        while (dealerTotal > 21) {
            System.out.println("Bust! Dealer loses.");
            System.out.println(0);
        }

        if (total > dealerTotal) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Dealer's wins!");
        }

    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static String cardString(int cardNumber) {
        String art1 = "   _____\n" +
                "  |A _  |\n" +
                "  | ( ) |\n" +
                "  |(_'_)|\n" +
                "  |  |  |\n" +
                "  |____V|\n";

        String art2 = "   _____\n" +
                "  |2    |\n" +
                "  |  o  |\n" +
                "  |     |\n" +
                "  |  o  |\n" +
                "  |____Z|\n";

        String art3 = "   _____\n" +
                "  |3    |\n" +
                "  | o o |\n" +
                "  |     |\n" +
                "  |  o  |\n" +
                "  |____E|\n";

        String art4 = "   _____\n" +
                "  |4    |\n" +
                "  | o o |\n" +
                "  |     |\n" +
                "  | o o |\n" +
                "  |____h|\n";

        String art5 = "   _____\n" +
                "  |5    |\n" +
                "  | o o |\n" +
                "  |  o  |\n" +
                "  | o o |\n" +
                "  |____S|\n";

        String art6 = "   _____\n" +
                "  |6    |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  | o o |\n" +
                "  |____6|\n";

        String art7 = "   _____\n" +
                "  |7    |\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |____7|\n";

        String art8 = "   _____\n" +
                "  |8    |\n" +
                "  |o o o|\n" +
                "  | o o |\n" +
                "  |o o o|\n" +
                "  |____8|\n";

        String art9 = "   _____\n" +
                "  |9    |\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |____9|\n";

        String art10 = "   _____\n" +
                "  |10  o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |o o o|\n" +
                "  |___10|\n";

        String art11 = "   _____\n" +
                "  |J  ww|\n" +
                "  | o {)|\n" +
                "  |o o% |\n" +
                "  | | % |\n" +
                "  |__%%[|\n";

        String art12 = "   _____\n" +
                "  |Q  ww|\n" +
                "  | o {(|\n" +
                "  |o o%%|\n" +
                "  | |%%%|\n" +
                "  |_%%%O|\n";

        String art13 = "   _____\n" +
                "  |K  WW|\n" +
                "  | o {)|\n" +
                "  |o o%%|\n" +
                "  | |%%%|\n" +
                "  |_%%%>|\n";

        switch (cardNumber) {
            case 1:
                return art1;
            case 2:
                return art2;
            case 3:
                return art3;
            case 4:
                return art4;
            case 5:
                return art5;
            case 6:
                return art6;
            case 7:
                return art7;
            case 8:
                return art8;
            case 9:
                return art9;
            case 10:
                return art10;
            case 11:
                return art11;
            case 12:
                return art12;
            case 13:
                return art13;
            default:
                return "";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("Would you like to hit or stay?");
        String response = scan.nextLine();

        while (!(response.equals("hit") || response.equals("stay"))) {
            System.out.println("Please write hit or stay?");
            response = scan.nextLine();
        }
        return response;
    }
}