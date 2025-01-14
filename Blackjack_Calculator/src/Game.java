import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Scanner sc = new Scanner(System.in);
    Dealer newDealer;
    Player player;

    public void startGame(){
        displayMenu();
        String response = sc.nextLine().strip();
        displayBreakLine();
        switch (response){
            case "1":
                playGame();
                break;
            case "2":
                enterManually();
                break;
            case "3":
                System.out.println("You have exited the game!");
                break;
            default:
                System.out.println("ERROR: Wrong Input");
                System.out.println("");
                startGame();
                break;
        }
    }

    public void displayMenu(){
        System.out.println("Welcome to the blackjack strategy game!");
        displayBreakLine();
        System.out.println("1. Play a game");
        System.out.println("2. Enter cards in manually");
        System.out.println("3. Exit");
    }

    public void playGame(){
        System.out.println("You have selected to play a game");
        System.out.println();
        newDealer = new Dealer(createDecks(selectAmountOfDecks()));
        player = new Player(selectPlayerBalance());
        gameLoop();


    }
    public void initialSetup(){
        getBetAmount();
        player.setIsInitialChoice(true);
        newDealer.shuffleDecks();
        newDealer.dealCardToPlayer(player);
        newDealer.dealCardToDealer();
        newDealer.dealCardToPlayer(player);
        newDealer.dealCardToDealer();
        displayCurrentGame();
    }

    public void getBetAmount(){
        while(true){
            System.out.println("How much would you like to bet?");
            if(sc.hasNextInt()){
                int betAmount = sc.nextInt();
                if(betAmount > player.getPlayerBalance()){
                    System.out.println("ERROR: Insufficient balance");
                    displayBreakLine();
                    sc.nextLine();
                    continue;
                } else if (betAmount <= 0) {
                    System.out.println("ERROR: Must put up a positive bet amount");
                    displayBreakLine();
                    sc.nextLine();
                    continue;
                }
                player.placeBet(betAmount);
                break;
            }
            System.out.println("ERROR: Invalid input");
            displayBreakLine();
            sc.nextLine();  // Clear invalid input
        }
    }
    public void displayCurrentGame(){
        for (Card c :newDealer.getDealerHand().getAllCards()) {
            System.out.println(c.getSuitAndValue());
        }
        System.out.println();
        for (Card c :player.getPlayerHand().getAllCards()) {
            System.out.println(c.getSuitAndValue());
        }

        displayBreakLine();
        System.out.println("Current wager: " + player.getCurrentBet());
        System.out.println(ANSI_YELLOW +"Dealers' Hand:");
        System.out.print("FLIPPED     ");
        System.out.print(newDealer.getDealerHand().getCardAtIndex(1).getSuitAndValue());
        System.out.println();
        System.out.println();
        System.out.println(ANSI_GREEN + "Players' Hand:");
        for(Card c : player.getPlayerHand().getAllCards()){
            System.out.print(c.getSuitAndValue() + "     ");
        }
        System.out.println(ANSI_RESET);
    }

    public void displayBestOption(){
        System.out.println("Current best option is: ");
    }
    public void displayPlayerOptions(){
        displayBreakLine();
        System.out.println("HIT");
        System.out.println("STAND");
        if(player.canDoubleBet() && player.getIsInitialChoice()){
            if(player.getPlayerHand().canSplit()){
                System.out.println("SPLIT");
            }
            System.out.println("DOUBLE DOWN");
        }

    }


    public void gameLoop(){
        while(true){
            initialSetup();
            displayBestOption();
            displayPlayerOptions();
            getPlayerChoice();
        }
    }
    public void enterManually(){
        System.out.println("You have selected to enter cards in manually");
        System.out.println();
        createDecks(selectAmountOfDecks());

    }

    public void getPlayerChoice(){
        sc.nextLine();
        while(true){
            System.out.println("Enter in your choice (HIT, STAND, SPLIT, DOUBLE DOWN)");
            String choice = sc.nextLine().toUpperCase().trim();

            if(choice.equals("HIT")){
                player.hit();
                break;

            } else if (choice.equals("STAND")) {
                player.stand();
                break;

            } else if (player.canDoubleBet() && player.getIsInitialChoice()){
                if(player.getPlayerHand().canSplit() && choice.equals("SPLIT")){
                    player.split();
                    break;
                } else if(choice.equals("DOUBLE DOWN")){
                    player.doubleDown();
                    break;
                }
            }
            System.out.println("ERROR: Invalid input");
            displayBreakLine();
        }

    }
    public int selectAmountOfDecks() {

        int[] validDecks = {1, 2, 4, 6, 8};  // Valid deck options
        while (true) {
            System.out.println("How many decks in play (1, 2, 4, 6 or 8)?");
            if (sc.hasNextInt()) {
                int amountOfDecks = sc.nextInt();
                for (int valid : validDecks) {
                    if (amountOfDecks == valid) {
                        return amountOfDecks;
                    }
                }
            }
            System.out.println("ERROR: Invalid input");
            displayBreakLine();
            sc.nextLine();  // Clear invalid input
        }
    }

    public int selectPlayerBalance() {
        sc.nextLine();
        while (true) {
            System.out.println("Would you like to start with the default balance (100) (or enter your own)? (Y/N)");
            String answer = sc.nextLine().trim().toUpperCase();

            if (answer.equals("Y")) {
                return 100;  // Default balance
            } else if (answer.equals("N")) {
                break;
            } else {
                System.out.println("ERROR: Invalid input");
                displayBreakLine();
            }
        }

        sc.nextLine();
        while (true) {
            System.out.println("Enter balance amount (up to 10,000,000):");
            if (sc.hasNextInt()) {
                int balance = sc.nextInt();
                if (balance > 0 && balance <= 10_000_000) {
                    return balance;
                }
            }
            System.out.println("ERROR: Invalid input");
            displayBreakLine();
            sc.nextLine();  // Clear invalid input
        }
    }

    public void displayBreakLine(){
        System.out.println("______________________________");
    }

    public Deck createDecks(int amount){
        Deck d = new Deck();
        for(int i = 0; i< amount -1;i++){
            Deck temp = new Deck();
            d.addCards(temp.getAllCards());
        }
        return d;
    }

}
