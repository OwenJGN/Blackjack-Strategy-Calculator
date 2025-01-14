import java.util.List;

public class Dealer{

    Deck deck;
    Hand dealerHand;
    public Dealer(Deck deck){
        this.deck = deck;
        this.dealerHand = new Hand();
    }

    public void shuffleDecks(){
        deck.resetDeck();
        deck.shuffleDeck();
    }

    public void dealCardToPlayer(Player p){
        Card c = deck.getCard();
        p.addCardToHand(c);
        deck.addCardInPlay(c);
    }

    public void dealCardToDealer() {
        Card c = deck.getCard();
        this.dealerHand.addCard(c);
        deck.addCardInPlay(c);

    }

    public Hand getDealerHand(){
        return this.dealerHand;
    }

    public int getCardAmount(){
        int amount=0;
        amount+=deck.getCardCount();
        return amount;
    }

    public void resetDecks(){
        deck.resetDeck();
    }

}
