import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
/* Lien du puzzle : https://www.codingame.com/training/easy/horse-racing-duals */
 
class HorseRacingDual {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Set<Integer> powers = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            powers.add(pi);
        }
        
        int diffMin = Integer.MAX_VALUE;
        Object tabPowers[] = powers.toArray();
        if (powers.size() != N){
            diffMin = 0;
        } else {
            for (int i = 1; i<N; i++){
                if (diffMin>Math.abs((Integer)tabPowers[i-1]-(Integer)tabPowers[i])){
                    diffMin = Math.abs((Integer)tabPowers[i-1]-(Integer)tabPowers[i]);
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(diffMin);
    }
}
