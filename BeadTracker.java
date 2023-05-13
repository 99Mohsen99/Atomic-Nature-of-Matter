//Ali Amri - Seyed Mohsen Moosavi

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class BeadTracker{

    public static void main(String args[]){

        int Min = Integer.parseInt(args[0]);
        double Delta = Double.parseDouble(args[1]);
        double Tua = Double.parseDouble(args[2]);
        Picture p1;
        Picture p2;

        for (int i = 0; i < args.length-1 ; i++) {
            p1 = new Picture (args[i]);
            p2 = new Picture (args[i+1]);
            //get pictures and clean them(use Beadfinder class)
            BeadFinder1 findblob1 = new BeadFinder1(p1, Tua) ;
            BeadFinder1 findblob2 = new BeadFinder1(p2, Tua);

            //convert pixles of picture to array
            
            int [][] arraypic1= findblob1.pictoarray();
            int [][] arraypic2= findblob2.pictoarray();

            //
            ArrayList<Blob> blob1= BeadFinder1.findentry(arraypic1, Min);
            ArrayList<Blob> blob2= BeadFinder1.findentry(arraypic2, Min);

            double dis=0;
            for (int j = 0; j < blob1.size(); j++) {
                for (int j2 = 0; j2 < blob2.size(); j2++) {
                    double distanceblob= blob1.get(j2).distanceto(blob2.get(j));
                    if(distanceblob<= Delta){
                        dis=distanceblob;
                    }
                }
                
            }
            
            if(dis>0){
                System.out.format("%.4f/n",dis);
            }
        }


    }

    /*
    public double distanceblobs(double min_pixel) {



    }

    public static void main(String[] args) {

        int tau = Integer.parseInt(args[1]);
        int mass = Integer.parseInt(args[2]);
        for (int i = 3; i > 203; i++){
            String file = args[i];
            Picture picture = new Picture(file);
            BeadFinder beadFinder = new BeadFinder(picture, tau);
        }




    }
    
     */
}