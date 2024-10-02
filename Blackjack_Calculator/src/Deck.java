import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {


    List<Card> deckOfCards;

    public Deck(){
        deckOfCards = new ArrayList<>();

    }

    public void shuffleDeck(){
        List<Card> newDeck = new ArrayList<>();

        while(deckOfCards.size() > 0){
            int newIndex = (int) (Math.random() * deckOfCards.size());
            newDeck.add(deckOfCards.remove(newIndex));
        }
            deckOfCards = newDeck;
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
