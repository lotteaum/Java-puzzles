import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle : https://www.codingame.com/training/medium/aneo */

class Aneo {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();
        System.err.println("Limit speed : " + speed + " km/h");
        int lightCount = in.nextInt();
        System.err.println(lightCount + " feu(x) rouge(s)");
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Integer> durations = new ArrayList<Integer>();
        for (int i = 0; i < lightCount; i++) {
            int distance = in.nextInt();
            distances.add(distance);
            System.err.println("Distance du feu " + (i+1) + " (m) : " + distance);
            int duration = in.nextInt();
            durations.add(duration);
            System.err.println("Durée (s) : " + duration);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        
        int speedMax = speed;
        int nbFeuxRouges = -1;
        while (speedMax > 0 && nbFeuxRouges != 0) {
            nbFeuxRouges = 0;
            for (int i = 0; i<lightCount; i++){
                nbFeuxRouges += (distances.get(i)*3600/(speedMax*1000*durations.get(i)))%2;
            }
            if (nbFeuxRouges > 0){
                speedMax--;
            }
        }

        System.out.println(speedMax);
    }
}
