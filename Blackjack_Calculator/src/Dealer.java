import java.util.List;

public class Dealer{

    List<Deck> decks;
    int amountOfDecks;
    Hand dealerHand;
    public Dealer(List<Deck> decks){
        this.decks = decks;
        this.dealerHand = new Hand();
    }

    public void shuffleDecks(){
        for (Deck d: this.decks) {
            d.shuffleDeck();
        }
    }

    public void dealCardToPlayer(Player p){
        Card c = decks.get(0).getCard();
        p.addCardToHand(c);

    }

    public void dealCardToDealer() {
        Card c = decks.get(0).getCard();
        this.dealerHand.addCard(c);
    }
    
    public void play(){

    }
    public Hand getDealerHand(){
        return this.dealerHand;
    }


}
