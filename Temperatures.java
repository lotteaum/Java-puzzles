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
        int n = in.nextInt(); // the number of temperatures to analyse
        int result;
        if (n==0) {
            result = 0;
        } else {
            result = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (Math.abs(t)<Math.abs(result) || t>0 && t== -result){
                result = t;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(Integer.toString(result));
    }
}
