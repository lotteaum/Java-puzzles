import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien : https://www.codingame.com/training/easy/lumen */

class Lumen {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        System.err.println(N + " " + L);
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        List<Integer> absLight = new ArrayList<>();
        List<Integer> ordLight = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String LINE = in.nextLine();
            System.err.println(LINE);
            for (int j = 0; j<N; j++){
                if (LINE.charAt(2*j)=='C'){
                    absLight.add(i);
                    ordLight.add(j);
                    //System.err.println("Light : " + i + " " + j);
                }
            }
        }
        
        int nbCasesNoires = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                int d = distance(i,j,absLight,ordLight);
                //System.err.println(i + " " + j + " -> " + d);
                if (d>=L){
                    
                    nbCasesNoires++;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(nbCasesNoires);
    }
    
    public static int distance(int i, int j, List<Integer> absc, List<Integer> ord){
        int dist = Integer.MAX_VALUE;
        for (int k = 0; k<absc.size(); k++){
            int d = Math.max(Math.abs(i-absc.get(k)),Math.abs(j-ord.get(k)));
            dist = Math.min(d,dist);
        }
        return dist;
    }
}
