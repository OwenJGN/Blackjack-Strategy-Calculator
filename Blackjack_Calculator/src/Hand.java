import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> currentHand;

    public void addCard(Card c){
        currentHand = new ArrayList<>();
        currentHand.add(c);
    }

    public void clearHand(){
        currentHand.clear();
    }

    public int handValue(){
        int value = 0;
        for (Card c : currentHand) {
            value += c.getCardValue();
        }
        return value;
    }

    public boolean isBust(){
        if(this.handValue() <= 21){
            return false;
        }
        return true;
    }

    public boolean hasBlackjack(){
        if(currentHand.size() == 2 && handValue() == 21){
            return true;
        }
        return false;
    }

    public Card getCardAtIndex(int i){
        return currentHand.get(i);
    }

    public List<Card> getAllCards(){
        return this.currentHand;
    }
}

