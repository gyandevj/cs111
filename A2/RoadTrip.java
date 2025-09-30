public class RoadTrip {
    public static void main(String[] args) {
        double gallons = Double.parseDouble(args[0]);
        double mpg = Double.parseDouble(args[1]);
        boolean isRaining = Boolean.parseBoolean(args[2]);
        boolean hasMountainPass = Boolean.parseBoolean(args[3]);
        int numPassengers = Integer.parseInt(args[4]);
        boolean isWeekend = Boolean.parseBoolean(args[5]);

        if (isWeekend) mpg *= 0.70;
        if (isRaining) mpg *= 0.85;
        if (hasMountainPass) mpg *= 0.90;
        if (numPassengers >= 3) mpg *= 1.05;

        double distance = gallons * mpg;

        System.out.printf("Expected range: %.1f miles%n", distance);
    }
}