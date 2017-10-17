/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author laveh2107
 */
public class Deck {

    //instance variable
    private Card[] cards;
    private int numCards;
    private boolean isShuffled;

    public Deck() {
        reset();
    }

    public void shuffle() {
        //Fischers-Yates shuffle algorithm
        for (int i = 0; i < numCards; i++) {
            //generate random spot to swap with
            int spot = (int) (Math.random() * (numCards - i) + i);
            //Swap cards
            Card temp = cards[i];
            cards[i] = cards[spot];
            cards[spot] = temp;
        }
        //Set shuffled true
        isShuffled = true;
    }

    public boolean isShuffled() {
        return this.isShuffled;
    }

    public int getnumberCardsLeft() {
        return this.numCards;
    }

    public Card dealCard() {
        this.numCards--;
        //deal out a card
        return this.cards[this.numCards];
    }

    public void reset() {
        this.numCards = 52;
        this.isShuffled = false;

        this.cards = new Card[52];
        //put the cards in the deck
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                Card c = new Card(rank, suit);
                this.cards[13 * suit + rank - 1] = c;
            }
        }
    }

    public void printDeck() {
        for (int i = numCards - 1; i >= 0; i--) {
            System.out.println(cards[i]);
        }
    }
}
