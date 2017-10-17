/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CardGame;

import java.util.ArrayList;

/**
 *
 * @author laveh2107
 */
public class War {

    public static int winner(Card p1Card, Card p2Card) {
        //did a war happen?
        if (p1Card.getRank() == p2Card.getRank()) {
            return 0;
            //Check if player 1 wins
        } else if (p1Card.getRank() == 1 || (p1Card.isBigger(p2Card) && p2Card.getRank() != 1)) {
            System.out.println("Player 1 wins this round");
            return 1;
        } else {
            System.out.println("Player 2 wins this round");
            return 2;
        }

    }

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

            //Who wins:?
            int winner = winner(p1Card, p2Card);


            //did a war happen?
            if (winner == 0) {
                System.out.println("WAR");
                //Create card pikle for cards
                ArrayList<Card> pile = new ArrayList<>();
                //Keep playing until someone wins
                while (winner == 0) {
                    //make sure players have enought cards
                    if(p1.getNumCards() < 4){
                        System.out.println("Player 1 ran out of cards for war");
                        //p1 loses
                        winner = 2;
                        //get rid of their cards
                        while(p1.getNumCards() > 0){
                            p1.playCard();
                        }
                        break;
                    }else if(p2.getNumCards() < 4){
                        System.out.println("Player 2 ran out of cards for war");
                        //p2 loses
                        winner = 1;
                        //get rid of their cards
                        while(p2.getNumCards() > 0){
                            p2.playCard();
                        }
                        break;
                    }
                    //add inn already played cards
                    pile.add(p1Card);
                    pile.add(p2Card);
                    //draw three cards from each player to add to pile
                    Card[] p1Cards = p1.get3Cards();
                    Card[] p2Cards = p2.get3Cards();
                    for (int i = 0; i < 3; i++) {
                        pile.add(p1Cards[i]);
                        pile.add(p2Cards[i]);
                    }
                    //new card for each player
                    p1Card = p1.playCard();
                    p2Card = p2.playCard();
                    System.out.println("Player 1 plays " + p1Card);
                    System.out.println("Palyer 2 plays " + p2Card);
                    winner = winner(p1Card, p2Card);
                }

                //war is over
                //Add pile to the victor
                if (winner == 1) {
                    //for each card in the pile
                    for (Card aCard : pile) {
                        p1.takeCard(aCard);
                    }
                }
            } else if (winner == 1) {
                //take both cards
                p1.takeCard(p2Card);
                p1.takeCard(p1Card);
            } else {
                //take both cards
                p2.takeCard(p1Card);
                p2.takeCard(p2Card);
            }
            System.out.println("");
        }
        if(p1.getNumCards() > 0){
            System.out.println("Player 1 wins");
        }else {
            System.out.println("Player 2 wins");
        }
    }
}
