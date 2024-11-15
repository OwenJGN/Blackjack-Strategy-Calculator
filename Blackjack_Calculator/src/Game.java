import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    Dealer newDealer;
    Player player;
    boolean isHandFinished = false;
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
        initialSetup();
        displayPlayerOptions();
        displayBestOption();
        //TODO: GET THE PLAYERS CHOICE FOR HIT STAND SPLIT OR DOUBLE DOWN


    }
    public void initialSetup(){
        newDealer.shuffleDecks();
        newDealer.dealCardToPlayer(player);
        newDealer.dealCardToDealer();
        newDealer.dealCardToPlayer(player);
        newDealer.dealCardToDealer();
        displayCurrentGame();
        displayPlayerOptions();
    }

    public void displayCurrentGame(){
        System.out.println("Dealers' Hand:");
        System.out.println("FLIPPED     ");
        System.out.print(newDealer.getDealerHand().getCardAtIndex(1).getSuitAndValue());
        System.out.println();
        System.out.println();
        System.out.println("Players' Hand:");
        System.out.println();
        for(Card c : player.getPlayerHand().getAllCards()){
            System.out.print(c.getSuitAndValue() + "     ");
        }
    }

    public void displayBestOption(){
        System.out.println("Current best option is: ");
    }
    public void displayPlayerOptions(){
        displayBreakLine();
        System.out.println("1. HIT");
        System.out.println("2. STAND");
        System.out.println("3. SPLIT");
        System.out.println("#4. DOUBLE DOWN");
        displayBreakLine();
    }
    public void gameLoop(){
        while(!isHandFinished){

        }
    }
    public void enterManually(){
        System.out.println("You have selected to enter cards in manually");
        System.out.println();
        createDecks(selectAmountOfDecks());

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

        while (true) {
            System.out.println("Would you like to start with the default balance (100) or enter your own? (Y/N)");
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

    public List<Deck> createDecks(int amount){
        List<Deck> decks = new ArrayList<>();
        for(int i = 0; i< amount;i++){
            Deck deck = new Deck();
            decks.add(deck);
        }
       return decks;
    }

}
