import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
/* Lien du puzzle Codingame : https://www.codingame.com/training/medium/stock-exchange-losses */

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.err.println(n);
        int maxLocal = 0;
        int looseMax = 0;
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            if (v>maxLocal){
                maxLocal = v;
            }
            if (v-maxLocal < looseMax){
                looseMax = v-maxLocal;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(looseMax);
    }
}
