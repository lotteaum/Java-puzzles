import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle : https://www.codingame.com/training/medium/the-last-crusade-episode-1 */

class TheLastCrusade1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        int[][] tabCells = new int[W][H];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String[] pieces = LINE.split(" ");
            for (int j = 0; j<W; j++){
                tabCells[j][i] = Integer.valueOf(pieces[j]);
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            switch(tabCells[XI][YI]){
                case 1: case 3: case 7: case 8: case 9: case 12: case 13:
                    YI++;
                    break;
                case 2: case 6:
                    if (POS.equals("LEFT")){
                        XI++;
                    } else {
                        XI--;
                    }
                    break;
                case 4:
                    if (POS.equals("TOP")){
                        XI--;
                    } else {
                        YI++;
                    }
                    break;
                case 5:
                    if (POS.equals("TOP")){
                        XI++;
                    } else {
                        YI++;
                    }
                    break;
                case 10:
                    XI--;
                    break;
                case 11:
                    XI++;
            }
            

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println(XI + " " + YI);
        }
    }
}
