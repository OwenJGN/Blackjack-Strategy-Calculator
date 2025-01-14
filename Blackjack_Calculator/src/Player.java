public class Player {

    Hand playerHand;
    int playerBalance = 100;
    int currentBet;

    boolean isInitialChoice;
    public Player(int balance){
        playerBalance = balance;
        this.playerHand = new Hand();
        isInitialChoice = true;
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
        isInitialChoice = false;
    }

    public void stand(){
        isInitialChoice = false;
    }

    public void split(){
        isInitialChoice = false;
    }

    public void doubleDown(){
        isInitialChoice = false;

    }

    public int getCurrentBet() {
        return currentBet;
    }

    public boolean canDoubleBet(){
        if(currentBet * 2 <= playerBalance){
            return true;
        }
        return false;
    }

    public boolean getIsInitialChoice(){
        return isInitialChoice;
    }

    public void setIsInitialChoice(boolean b){
        isInitialChoice= b;
    }
}
