/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

/**
 *
 * @author laveh2107
 */
public class War {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create deck of cards
        Deck deck = new Deck();
        //Create new palyers
        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");

        //Shuffle the deck and deal cards
        deck.shuffle();
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                p1.takeCard(deck.dealCard());
            } else {
                p2.takeCard(deck.dealCard());
            }
        }

        //GAME TIME
        //As long as players have cards 
        while (p1.getNumCards() > 0 && p2.getNumCards() > 0) {
            //Palyer 1's card
            Card p1Card = p1.playCard();
            System.out.println("Player 1 plays " + p1Card);
            //player 2 card
            Card p2Card = p2.playCard();
            System.out.println("player 2 plays " + p2Card);
            //did a war happen?
            if (p1Card.getRank() == p2Card.getRank()) {
                //War code
                System.out.println("WAR");
                //Check if player 1 wins
            } else if (p1Card.getRank() == 1 || p1Card.isBigger(p2Card)) {
                System.out.println("Player 1 wins this round");
                //take both cards
                p1.takeCard(p2Card);
                p1.takeCard(p1Card);
            } else {
                System.out.println("Player 2 wins this round");
                //take both cards
                p2.takeCard(p1Card);
                p2.takeCard(p2Card);
            }
            //Space to seperate rounds
            System.out.println("");
        }
    }
}
