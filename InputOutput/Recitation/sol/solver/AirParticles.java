import java.util.Scanner;

public class AirParticles {

    // returns the largest value in communities; if empty returns Double.NaN
    public static double findHighestLevel(double[] communities) {
        if (communities == null || communities.length == 0) return Double.NaN;
        double max = communities[0];
        for (int i = 1; i < communities.length; i++) {
            if (communities[i] > max) max = communities[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // first token is total number of lines / entries
        if (!in.hasNextInt()) {
            System.out.println("Highest PM2.5 Level is " + Double.NaN);
            in.close();
            return;
        }
        int n = in.nextInt();
        double[] arr = new double[n];

        // read up to n doubles (file should provide them)
        for (int i = 0; i < n && in.hasNext(); i++) {
            if (in.hasNextDouble()) {
                arr[i] = in.nextDouble();
            } else {
                // skip non-double tokens if present
                in.next();
                i--; // don't advance index
            }
        }
        in.close();

        double highest = findHighestLevel(arr);
        System.out.println("Highest PM2.5 Level is " + highest);
    }
}
