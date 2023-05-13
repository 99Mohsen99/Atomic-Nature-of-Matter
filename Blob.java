import java.util.ArrayList;

public class Blob {

    ArrayList<Integer> blob_x= new ArrayList<Integer>();
    ArrayList<Integer> blob_y= new ArrayList<Integer>();
    
    double[] center= new double[2];
    public Blob(){

    }
    public void add(int x, int y) {
        blob_x.add(x);
        blob_y.add(y);
    }

    public double[] centerOfBlob() {
        // center[0]==x of center , center[1]==y of center


        double xx=0;
        double yy=0;

        for (int i=0;i<blob_x.size();i++) {
            xx+=blob_x.get(i);
            yy+=blob_y.get(i);
        }

        center[0]=xx/blob_x.size();
        center[1]=yy/blob_y.size();

        return center;
    }


    public boolean mass (int mass) {
        if (blob_x.size()>=mass) {
            return true;
        }
        return false;
    }
    public double distanceto(Blob blob){
        double[] c = blob.centerOfBlob();
        return Math.sqrt(Math.pow((center[0] - c[0]), 2) + Math.pow((center[1] - c[1]), 2));
    }
    /*
    public double distanceto(double[] center){

        double variance = Math.sqrt(Math.pow())
    }

*/










}