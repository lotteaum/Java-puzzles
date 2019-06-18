import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle Codingame : https://www.codingame.com/training/medium/winamax-battle */

class WinamaxBattle {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        List<String> cardsPlayer1 = new LinkedList<>();
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            cardsPlayer1.add(cardp1);
        }
        
        List<String> cardsPlayer2 = new LinkedList<>();
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            cardsPlayer2.add(cardp2);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        
        List<String> tasPlayer1 = new LinkedList<>();
        List<String> tasPlayer2 = new LinkedList<>();
        int nbTours = 0;
        int winnerPlayer = 0;
        
        do {
            winnerPlayer = 0;
            nbTours++;
            boolean playerCapot = false;
            String card1 = cardsPlayer1.remove(0);
            String card2 = cardsPlayer2.remove(0);
            tasPlayer1.add(card1);
            tasPlayer2.add(card2);
            System.err.println("===== Tour " + nbTours + " =====");
            System.err.println("Joué : " + card1 + " - " + card2);
            
            while (valueCard(card1)==valueCard(card2)){
                System.err.println("Bataille !");
                System.err.println("Cartes défaussées :");
                for (int i = 0; i<3; i++){
                    if (cardsPlayer1.size()>0 && cardsPlayer2.size()>0){
                        String c1 = cardsPlayer1.remove(0);
                        String c2 = cardsPlayer2.remove(0);
                        tasPlayer1.add(c1);
                        tasPlayer2.add(c2);
                        System.err.println(c1 + " - " + c2);
                    } else {
                        playerCapot = true;
                        // Un des joueurs capot pendant la défausse
                        break;
                    }
                }
                if (cardsPlayer1.size()==0 && cardsPlayer2.size()==0){
                    playerCapot = true;
                    // Un des joueurs capot après la défausse
                }
                if (playerCapot){
                    break;
                }
                card1 = cardsPlayer1.remove(0);
                card2 = cardsPlayer2.remove(0);
                tasPlayer1.add(card1);
                tasPlayer2.add(card2);
                System.err.println("Joué : " + card1 + " - " + card2);
            }
            
            if (valueCard(card1)>valueCard(card2)){
                winnerPlayer = 1;
                cardsPlayer1.addAll(tasPlayer1);
                cardsPlayer1.addAll(tasPlayer2);
            } else if (valueCard(card2)>valueCard(card1)){
                winnerPlayer = 2;
                cardsPlayer2.addAll(tasPlayer1);
                cardsPlayer2.addAll(tasPlayer2);
            }
            System.err.println("Joueur gagnant : " + winnerPlayer);
            tasPlayer1.clear();
            tasPlayer2.clear();
        } while (cardsPlayer1.size()>0 && cardsPlayer2.size()>0);

        if (winnerPlayer == 0){
            System.out.println("PAT");
        } else {
            System.out.println(winnerPlayer + " " + nbTours);
        }
    }
    
    public static int valueCard(String card){
        char c = card.charAt(0);
        switch (c) {
            case '1':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return Integer.valueOf(String.valueOf(c));
        }
    }
}
