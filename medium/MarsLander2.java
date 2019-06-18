import java.util.*;
import java.io.*;
import java.math.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

/* Lien du puzzle Codingame : https://www.codingame.com/training/medium/mars-lander-episode-2 */

class MarsLander2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List listPointsH = new LinkedList();
        List listPointsV = new LinkedList();
        
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            listPointsH.add(landX);
            listPointsV.add(landY);
            System.err.println(landX + " " + landY);
        }
        
        // Find a good place to land
        int goodPlace = -1;
        for (int i = 0; i<surfaceN-1; i++){
            if ((int)listPointsV.get(i)==(int)listPointsV.get(i+1)){
                goodPlace = ((int)listPointsH.get(i) + (int)listPointsH.get(i+1))/2;
                break;
            }
        }
        
        // Find the summit altitude of the mountains
        int altSummit = -1;
        for (int i = 0; i<surfaceN; i++){
            if ((int)listPointsV.get(i)>altSummit){
                altSummit = (int)listPointsV.get(i);
            }
        }
        
        System.err.println("Place to land : " + goodPlace);
        System.err.println("Summit altitude : " + altSummit);
        
        int X, Y, hSpeed, vSpeed, fuel, rotate, power;

        // game loop
        while(true) {
            X = in.nextInt();
            Y = in.nextInt();
            hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            power = in.nextInt(); // the thrust power (0 to 4).
            
            
            if (Math.abs(X-goodPlace)>=500){
                if ((hSpeed*(X-goodPlace))>0){
                    power = 4;
                    rotate = ((X-goodPlace)<0)?-25:25;
                } else {
                    if (Math.abs(hSpeed)<40){
                        power = 4;
                        rotate = ((X-goodPlace)<0)?-25:25;
                    } else if (Math.abs(hSpeed)>45){
                        power = 4;
                        rotate = ((X-goodPlace)<0)?25:-25;
                    } else {
                        rotate = 0;
                        power = (vSpeed>0)?0:4;
                    }
                }
            } else if (Math.abs(hSpeed)>5){
                power = 4;
                rotate = (hSpeed>0)?45:-45;
            } else {
                rotate = 0;
                power = (vSpeed>-35?2:4);
            
        }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            System.out.println(rotate + " " + power);
        }
    }
}
