public class Player {

    Hand playerHand;
    int playerBalance = 100;
    int currentBet;

    public Player(int balance){
        playerBalance = balance;
        this.playerHand = new Hand();
    }

    public int getPlayerBalance(){
        return playerBalance;
    }

    public void setPlayerBalance(int playerBalance) {
        this.playerBalance = playerBalance;
    }

    public void placeBet(int amount){
        currentBet = amount;
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

    public Hand getPlayerHand(){

        return this.playerHand;
    }
    public void hit(){

    }

    public void stand(){

    }

    public void split(){

    }

    public void doubleDown(){

    }

    public int getCurrentBet() {
        return currentBet;
    }
}
