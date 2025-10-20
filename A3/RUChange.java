public class RUChange {
    public static void main(String[] args) {
        int c = Integer.parseInt(args[0]);
        if (c < 0) {
            System.out.println("Invalid input!");
            return;
        }
        int q = 0;
        int d = 0;
        int n = 0;
        int p = 0;
        while (c >= 25) {
            q++;
            c -= 25;
        }
        while (c >= 10) {
            d++;
            c -= 10;
        }
        while (c >= 5) {
            n++;
            c -= 5;
        }
        while (c >= 1) {
            p++;
            c -= 1;
        }
        System.out.println("Quarters: " + q);
        System.out.println("Dimes: " + d);
        System.out.println("Nickels: " + n);
        System.out.println("Pennies: " + p);
    }
}