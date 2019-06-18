import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/

/* Lien du puzzle : https://www.codingame.com/training/medium/there-is-no-spoon-episode-1 */

class ThereIsNoSpoon1 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        System.err.println(width + " " + height);
        if (in.hasNextLine()) {
            in.nextLine();
        }
        ArrayList<String> lines = new ArrayList<String>();
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            lines.add(line);
            System.err.println(line);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        for (int i = 0; i<width; i++){
            for (int j = 0; j<height; j++){
                if (lines.get(j).charAt(i)=='0'){
                    String nodeHo = findHorizontalNode(lines,i,j,width);
                    String nodeVe = findVerticalNode(lines,i,j,height);
                    System.out.println(i + " " + j + " " + nodeHo + " " + nodeVe);
                }
            }
        }
    }
    
    public static String findHorizontalNode(ArrayList<String> grille, int x, 
    int y, int width){
        int x1 = -1;
        int y1 = -1;
        String line = grille.get(y);
        for (int i = x+1; i<width; i++){
            if (line.charAt(i)=='0'){
                x1 = i;
                y1 = y;
                break;
            }
        }
        return Integer.toString(x1) + " " + Integer.toString(y1);
    }
    
    public static String findVerticalNode(ArrayList<String> grille, int x, 
    int y, int height){
        int x2 = -1;
        int y2 = -1;
        for (int j = y+1; j<height; j++){
            if (grille.get(j).charAt(x)=='0'){
                x2 = x;
                y2 = j;
                break;
            }
        }
        return Integer.toString(x2) + " " + Integer.toString(y2);
    }
}
