public class AirParticles {

    public static double findHighestLevel(double[] x) {
        double y = x[0];
        for (int z = 1; z < x.length; z++) {
            if (x[z] > y) y = x[z];
        }
        return y;
    }
    public static void main(String[] args) {
        int a = StdIn.readInt();
        double[] b = new double[a];
        for (int c=0; c<a; c++) {
            b[c] = StdIn.readDouble();
        }
        double d = findHighestLevel(b);
        StdOut.println("Highest PM2.5 Level is " + d);
    }
}
