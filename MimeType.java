import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        Map<String,String> extensions = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            extensions.put(EXT.toLowerCase(),MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            int indicePoint = FNAME.lastIndexOf('.');
            System.err.println(FNAME);
            System.err.println(indicePoint);
            if (indicePoint == -1){
                System.out.println("UNKNOWN");
                continue;
            }
            String ext = FNAME.substring(indicePoint+1).toLowerCase();
            if (extensions.containsKey(ext)){
                System.out.println(extensions.get(ext));
            } else {
                System.out.println("UNKNOWN");
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
