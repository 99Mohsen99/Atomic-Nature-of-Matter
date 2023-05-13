//Ali amri - Seyed Mohsen Moosavi

public class Avogadro {
    public static void main(String [] args){
        double T=297; //297k
        double viskozite= 9.1354e-4;
        double Ro= 0.5e-6;
        double K;
        double D;
        double R= 8.31457;

        double[] blob=StdIn.readAllDoubles();
        double ms=0;
        double mc=0;
        for (int i = 0; i < blob.length; i++) {
            ms+=Math.pow(blob[i]*0.174e-6,2);
            mc++;
        }
        D=ms/(2*mc);
        double mb=(6*3.1415*D*viskozite*Ro)/T;
        double Avogadro=R/mb;
        System.out.format("botzman = %.43/n",mb);
        System.out.format("Avogadro = %.43/n",Avogadro);
    }
}
