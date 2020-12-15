import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    //puts cards in the deck
    public void makeDeck(){
        for(Suit cardSuit: Suit.values()){
            for(Rank cardRank: Rank.values()){
                this.cards.add(new Card(cardSuit,cardRank));
            }
        }
    }

    //shuffle el deck
    public void shuffle(){
        ArrayList<Card> temp = new ArrayList<Card>();
        Random random = new Random();
        int randomCard = 0;
        int startingSize = this.cards.size();

        //adds card to the temp deck, and removes from original deck
        for(int i = 0; i < startingSize; i++){
            randomCard = random.nextInt((this.cards.size()-1-0)+1)+ 0;
            temp.add(this.cards.get(randomCard));
            this.cards.remove(randomCard);

        }
        this.cards = temp;
    }

    //returns card
    public String toString(){
        String playersCards = "";
        for(Card randomCard : this.cards){
            playersCards += "\n"  + "-" + randomCard.toString();
        }
        return playersCards;
    }

    public void remove(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }
    public void add(Card add){
        this.cards.add(add);
    }

    //draws cards from deck
    public void draw(Deck from){
        this.cards.add(from.getCard(0));
        from.remove(0);
    }

    public int size(){
        return this.cards.size();
   }

   public void moveCards(Deck move){
        int deckSize = this.cards.size();
        for(int i = 0; i <deckSize; i++){
        move.add(this.getCard(i));
        }
        for(int i = 0; i < deckSize; i++ ){
            this.remove(0);
        }
   }

    public int valueofCards() {
        int total = 0;
        int aces = 0;

        for (Card randomCard : this.cards) {
            switch (randomCard.getValues()) {
                case TWO:
                    total += 2;
                    break;
                case THREE:
                    total += 3;
                    break;
                case FOUR:
                    total += 4;
                    break;
                case FIVE:
                    total += 5;
                    break;
                case SIX:
                    total += 6;
                    break;
                case SEVEN:
                    total += 7;
                    break;
                case EIGHT:
                    total += 8;
                    break;
                case NINE:
                    total += 9;
                    break;
                case TEN:
                    total += 10;
                    break;
                case JACK:
                    total += 10;
                    break;
                case QUEEN:
                    total += 10;
                    break;
                case KING:
                    total += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (total > 10) {
                total += 1;
            } else {
                total += 11;
            }
        }
    return total;
    }
}
