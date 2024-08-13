import java.util.ArrayList;
import java.util.List;

public class Deck {

    int amountOfDecks;

    List<Card> deckOfCards;

    public Deck(int amount){
        amountOfDecks = amount;
        deckOfCards = new ArrayList<>();
    }

    public void shuffleDeck(){
        //todo
    }

    public Card getCard(){
        return deckOfCards.remove(0);
    }

    public void addCards(List<Card> cards){
        for (Card c : cards) {
            deckOfCards.add(c);
        }
    }

}
