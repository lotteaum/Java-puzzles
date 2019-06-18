import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
/* Lien du puzzle Codingame : https://www.codingame.com/training/medium/don't-panic-episode-1 */

class DontPanic1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        
        Map<Integer,Integer> flexit = new HashMap<>();
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            flexit.put(elevatorFloor,elevatorPos);
        }
        flexit.put(exitFloor,exitPos);
        int loop = 0;
        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            if (cloneFloor==-1){
                System.out.println("WAIT");
                continue;
            }
            
            String action = "WAIT";
            int positionToReach = flexit.get(cloneFloor);
            
                
            if (clonePos == 0 || clonePos== width-1){
                action = "BLOCK";
            } else if ((positionToReach-clonePos>0 && "LEFT".equals(direction)) ||
            (positionToReach-clonePos<0 && "RIGHT".equals(direction))){
                action = "BLOCK";
            }
            
            System.err.println("Position to reach : " + positionToReach);
            System.err.println("Head clone position : " + clonePos);

            System.out.println(action); // action: WAIT or BLOCK
        }
    }
}
