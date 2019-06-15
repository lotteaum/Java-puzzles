import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
 /* Lien du puzzle : https://www.codingame.com/training/easy/defibrillators */
 
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<String> noms = new LinkedList<>();
        List<Double> latitudes = new LinkedList<>();
        List<Double> longitudes = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            System.err.println(DEFIB);
            // Extraction du nom
            String str = DEFIB.substring(DEFIB.indexOf(';')+1);
            String nom = str.substring(0,str.indexOf(';'));
            noms.add(nom);
            
            // Extraction de la latitude
            String latitudeStr = str.substring(str.lastIndexOf(';')+1).replace(',','.');
            double latitude = Double.valueOf(latitudeStr)*Math.PI/180;
            latitudes.add(latitude);
            
            // Extraction de la longitude
            str = str.substring(0,str.lastIndexOf(';'));
            
            String longitudeStr = str.substring(str.lastIndexOf(';')+1).replace(',','.');
            double longitude = Double.valueOf(longitudeStr)*Math.PI/180;
            longitudes.add(longitude);
        }
        
        // Recherche du plus proche défibrillateur
        double lon = Double.valueOf(LON.replace(',','.'))*Math.PI/180;
        double lat = Double.valueOf(LAT.replace(',','.'))*Math.PI/180;
        
        double x0 = (longitudes.get(0)-lon)*Math.cos(0.5*(lat+latitudes.get(0)));
        double y0 = (latitudes.get(0)-lat);
        double dMin = 6371*Math.sqrt(Math.pow(x0,2)+Math.pow(y0,2));
        int indiceMin = 0;
        System.err.println(dMin);
        
        for (int i = 1; i<N; i++){
            double xi = (longitudes.get(i)-lon)*Math.cos(0.5*(lat+latitudes.get(0)));
            double yi = (latitudes.get(i)-lat);
            double di = 6371*Math.sqrt(Math.pow(xi,2)+Math.pow(yi,2));
            System.err.println(di);
            if (di<dMin){
                dMin = di;
                indiceMin = i;
            }
        }

        // Affichage du résultat
        System.out.println(noms.get(indiceMin));
    }
}
