public class Card {

    enum Suit { Hearts, Diamonds, Spades, Clubs}
    enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE;
    }

    Suit suit;
    Value value;

    public Card (Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public int getCardValue(){

        switch(this.value){
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN:
            case QUEEN:
            case JACK:
            case KING:
                return 10;
            case ACE: return 11;
            default: return 0;
        }
    }

    public String getSuit(){
        return this.suit.toString();
    }
}
