import java.util.*;
import java.io.*;
import java.math.*;
import java.lang.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle : https://www.codingame.com/training/easy/chuck-norris */

class ChuckNorris {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        StringBuilder s = new StringBuilder();
        System.err.println(MESSAGE);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        for (int i = 0; i<MESSAGE.length(); i++){
            s.append(charToBin(MESSAGE.charAt(i)));
        }
        String norris = binToNorris(s.toString());
        System.out.println(norris);
    }
    
    public static String charToBin(char c){
        byte b = (byte) c;
        StringBuilder s = new StringBuilder();
        
        for (int i = 1; i<8; i++){
            String ch = Integer.toString(((b<<i)/128)%2);
            s.append(ch);
        }
        return s.toString();
    }
    
    public static String binToNorris(String message){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i<message.length(); i++){
            if (i==0 || message.charAt(i)!=message.charAt(i-1)){
                if (i>0) {
                    s.append(' ');
                }
                String toAdd = (message.charAt(i)=='1')?"0 0":"00 0";
                s.append(toAdd);
            } else {
                s.append('0');
            }
        }
        return s.toString();
    }
}
