public class Multiples {
    public static void main(String[] args) {
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        boolean Z1 = num1 == 0;
        boolean Z2 = num2 == 0;
        boolean div = !Z2 && num1 % num2 == 0;
        boolean result = Z1 || Z2 || div;
        System.out.println(result);
    }
}