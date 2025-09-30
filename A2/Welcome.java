public class Welcome {
    public static void main(String[] args) {
        int a = 4 / 2;       // integer division
        double b = 4.0 / 2.0; // floating-point division

        // Compare values
        if (a == b) {
            System.out.println("They are the same.");
        } else {
            System.out.println("They are different.");
        }

        // Print values
        System.out.println("4/2 = " + a);
        System.out.println("4.0/2.0 = " + b);
    }
}
