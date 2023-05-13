import java.awt.Color;
//import java.lang.reflect.Array;
import java.util.ArrayList;

public class BeadFinder1 {
    // Blob blob = new Blob();
    // ArrayList<Blob> blobs = new ArrayList<>();

    //------------------------------------------------------------------

    static Picture pic;
    static double tau;

    public BeadFinder1 (Picture pic01, double tau01){
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                Color color=pic.get(i,j);
                if (color.getRed() >= tau && color.getBlue()>=tau && color.getGreen()>=tau ) {
                    pic.set(i, j, Color.WHITE);
                } else {
                    pic.set(i, j, Color.BLACK);
                }
            }
        }
    }

    /*public static Picture pic_changer() {
        for (int i = 0; i < pic.height(); i++) {
            for (int j = 0; j < pic.width(); j++) {
                Color color=pic.get(i,j);
                if (color.getRed() >= tau && color.getBlue()>=tau && color.getGreen()>=tau ) {
                    pic.set(i, j, Color.WHITE);
                } else {
                    pic.set(i, j, Color.BLACK);
                }
            }
        }
        return pic;
    }
    */
    //--------------------------------------------------------------------


    public int[][] pictoarray() {
        int[][] Picture_array = new int[pic.width()][pic.height()];
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                Color color=pic.get(i,j);
                if (color.getRed() >= tau && color.getBlue()>=tau && color.getGreen()>=tau) {
                    Picture_array[i][j] = 1;
                } else {
                    Picture_array[i][j] = 0;
                }
            }
        }
        return Picture_array;
    }

    //----------------------------------------------------------------------------


    public static ArrayList<Blob> findentry(int[][] pic_array, int mass) {

        ArrayList<Blob> blob_list = new ArrayList<Blob>();
        for (int i = 0; i < pic_array.length; i++) {
            for (int j = 0; j < pic_array[0].length; j++) {
                if (pic_array[i][j] == 1) {
                    Blob blob01 = new Blob();
                    findblob(pic_array, j, i, blob01);

                    if (blob01.mass(mass)) {
                        blob_list.add(blob01);
                    }
                }
            }
        }
        return blob_list;
        /*
        Blob[] blob = new Blob[blob_list.size()];
        for (int i = 0; i < blob.length; i++) {
            blob[i] = blob_list.get(i);
        }
        return blob;
        */
    }

    //----------------------------------------------------------------------------
    public static void findblob(int[][] pic, int x, int y, Blob blob) {

        if (x == -1 || x == pic[0].length || y == -1 || y == pic.length) {
            return;
        }

        if (pic[y][x] == 0 || pic[y][x] == 2) {
            return;
        }


        pic[y][x] = 2;

        blob.add(x, y);

        findblob(pic, x + 1, y, blob);
        findblob(pic, x + 1, y + 1, blob);
        findblob(pic, x + 1, y - 1, blob);
        findblob(pic, x - 1, y + 1, blob);
        findblob(pic, x - 1, y - 1, blob);
        findblob(pic, x - 1, y, blob);
        findblob(pic, x, y + 1, blob);
        findblob(pic, x, y - 1, blob);

        return;
    }

    //---------------------------------------------------------------------------
    /*public ArrayList<Blob> getBeads(int min) {
        //if(blob.mass()>=25){  
        //}
        ArrayList<Blob> filter = new ArrayList<>();
        for (Blob b : blobs) {
            //if(b.mass() >= min) {
            //  filter.add(b);
            //}
        }
        return filter;
    }

     */

    //----------------------------------------------------------------------------
    public static void main(String[] args) {
        /* 
        int mass = Integer.parseInt(args[0]);
        int tau03 = Integer.parseInt(args[1]);
        String file = args[2];

        Picture pic03 = new Picture(file);

        pic = pic03;
        tau = tau03;

        int[][] pic_Array = pictoarray();

        Blob[] b = findentry(pic_Array,mass);

        for (int i=0;i<b.length;i++) {
            double[] xy= b[i].centerOfBlob();
            System.out.println(b[i].blob_x.size()+" ("+xy[0]+", "+xy[1]+")");
        }


        */
    }
    
}
