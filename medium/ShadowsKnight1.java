import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle : https://www.codingame.com/training/medium/shadows-of-the-knight-episode-1 */

class ShadowsKnight1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        int minW = 0;
        int maxW = W;
        int minH = 0;
        int maxH = H;
        
        int wCurr = X0;
        int hCurr = Y0;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            System.err.println("Direction to follow : " + bombDir);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            switch(bombDir)
            {
                case "U":
                    minW = wCurr;
                    maxW = wCurr;
                    maxH = hCurr-1;
                    break;
                case "UR" :
                    minW = wCurr+1;
                    maxH = hCurr-1;
                    break;
                case "R":
                    minW = wCurr+1;
                    minH = hCurr;
                    maxH = hCurr;
                    break;
                case "DR":
                    minW = wCurr+1;
                    minH = hCurr+1;
                    break;
                case "D":
                    minW = wCurr;
                    maxW = wCurr;
                    minH = hCurr+1;
                    break;
                case "DL":
                    maxW = wCurr-1;
                    minH = hCurr+1;
                    break;
                case "L":
                    maxW = wCurr-1;
                    minH = hCurr;
                    maxH = hCurr;
                    break;
                case "UL":
                    maxW = wCurr-1;
                    maxH = hCurr-1;
                    break;
            }

            // the location of the next window Batman should jump to.
            
            hCurr = (minH+maxH)/2;
            wCurr = (minW+maxW)/2;
            
            System.err.println("W : " + minW + " " + maxW);
            System.err.println("H : " + minH + " " + maxH);
            
            System.out.println(wCurr + " " + hCurr);
        }
    }
}
