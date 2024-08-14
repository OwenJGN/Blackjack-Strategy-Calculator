import java.util.List;

public class Dealer{

    List<Deck> decks;

    public Dealer(List<Deck> decks){
        this.decks = decks;
    }

    public void shuffleDecks(List<Deck> decks){
        for (Deck d: decks) {
            d.shuffleDeck();
        }
    }

    public void dealCard(Player p){
        p.addCardToHand(decks.get(0).getCard());
    }
    
    public void play(){

    }
}
