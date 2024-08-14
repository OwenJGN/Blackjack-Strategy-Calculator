public class Player {

    Hand playerHand;
    int playerBalance = 100;
    int currentBet;

    public Player(int balance){
        playerBalance = balance;
    }

    public int getPlayerBalance(){
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public void placeBet(int amount){
        if(amount <= playerBalance){
            removeBalance(amount);
            currentBet = amount;
        }else {
            System.out.println("ERROR: Can't bet more than you have available");
        }
    }

    public void winBet(){
        playerBalance += currentBet *2;
        currentBet = 0;
    }

    public void loseBet(){
        currentBet = 0;
    }

    public void addBalance(int amount){
        this.playerBalance += amount;
    }
    public void removeBalance(int amount){
        this.playerBalance -= amount;
    }

    public void addCardToHand(Card c){
        playerHand.addCard(c);
    }

    public void clearHand(){
        playerHand.clearHand();
    }

    public void hit(){

    }

    public void stand(){

    }

    public void split(){

    }

    public void doubleDown(){

    }
}
