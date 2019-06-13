import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
 /* */
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        ArrayList<ArrayList<Integer>> links = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            int nMin = Math.min(N1,N2);
            int nMax = Math.max(N1,N2);
            
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(nMin);
            l.add(nMax);
            links.add(l);
            //System.err.println("Noeud : " + nMin + " " + nMax);
        }
        
        ArrayList<Integer> exits = new ArrayList<Integer>();
        
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            System.err.println("Position Skynet : " + SI);
            boolean alert = false;
            for (int i = 0; i<links.size(); i++){
                ArrayList<Integer> link = links.get(i);
                if (link.contains(SI) && 
                (exits.contains(link.get(0)) || exits.contains(link.get(1)))){
                    String str = link.get(0) + " " + link.get(1);
                    System.err.println("Alerte ! Link supprimé : " + str);
                    System.out.println(str);
                    links.remove(link);
                    alert = true;
                    break;
                }
            }
            if (!alert){
                String str = links.get(0).get(0) + " " + links.get(0).get(1);
                System.err.println("Pas d'alerte. Link supprimé : " + str);
                System.out.println(str);
                links.remove(0);
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
}
