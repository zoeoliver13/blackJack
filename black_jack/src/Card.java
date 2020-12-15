public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.rank = rank;
        this.suit = suit;
    }

    //prints out value of rank and suit
    public String toString(){
        return this.rank.toString() + " of " + this.suit.toString();
    }
    //going to help determine the amount of points in a hand later
    public Rank getValues(){
        return this.rank;
    }
}
