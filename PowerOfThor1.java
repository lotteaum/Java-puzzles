import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
 
 
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position
        int TX = initialTX;
        int TY = initialTY;

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            
            System.err.println(lightX + " " + lightY);
            System.err.println(TX + " " + TY);
            
            int diffX = lightX-TX;
            int diffY = lightY-TY;
            
            String horiDir = (diffX==0)?"":((diffX>0)?"E":"W");
            String vertDir = (diffY==0)?"":((diffY>0)?"S":"N");
            
            TX = TX+((diffX==0)?0:((diffX>0)?1:-1));
            TY = TY+((diffY==0)?0:((diffY>0)?1:-1));


            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(vertDir+horiDir);
        }
    }
}
