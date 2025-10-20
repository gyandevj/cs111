public class HealthMonitor {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double d = Double.parseDouble(args[3]);
        double e = Double.parseDouble(args[4]);
        double f = Double.parseDouble(args[5]);
        double g = Double.parseDouble(args[6]);
        char h = args[7].charAt(0);
        char i = args[8].charAt(0);
        char j = args[9].charAt(0);
        char k = args[10].charAt(0);
        double l = (100 - a) / 10.0;
        double m = b % 8;
        double n = c;
        double o = d / 10.0;
        double p = 10 - e;
        double q;
        if (f >= 60 && f <= 100) {
            q = 10.0;
        } else if (f < 60) {
            q = 7.0;
        } else {
            q = 5.0;
        }
        double r = (g / 8000.0) * 10.0;
        double s;
        if (i == 'N') {
            s = 10.0;
        } else if (i == 'O') {
            s = 7.0;
        } else if (i == 'U') {
            s = 5.0;
        } else {
            s = 3.0;
        }
        double t;
        if (j == 'N') {
            t = 10.0;
        } else if (j == 'E') {
            t = 7.0;
        } else if (j == 'O') {
            t = 5.0;
        } else {
            t = 3.0;
        }
        double u;
        if (k == 'N') {
            u = 10.0;
        } else if (k == 'A') {
            u = 5.0;
        } else {
            u = 3.0;
        }

        double v = l * 0.10 + m * 0.10 + n * 0.10 + o * 0.10 + p * 0.10 + q * 0.10 + r * 0.05 + s * 0.15 + t * 0.10 + u * 0.10;

        String w;
        if (h == 'M') {
            if (v > 7.5) {
                w = "healthy";
            } else if (v >= 6.5) {
                w = "average";
            } else {
                w = "unhealthy";
            }
        } else {
            if (v > 7.0) {
                w = "healthy";
            } else if (v >= 6.0) {
                w = "average";
            } else {
                w = "unhealthy";
            }
        }
        System.out.println("Patient's health score of " + v + " is " + w + ".");
    }
}