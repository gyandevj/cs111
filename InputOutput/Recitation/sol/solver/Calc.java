public class Calc {
    public static void main(String[] args) {
        System.out.println("Enter two integers: ");
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        System.out.println("Enter an arithmetic operation: ");
        String operation = StdIn.readString();
        
        int result = 0;
        boolean hasError = false;
        
        if (operation.equals("+")) {
            result = add(a, b);
        } else if (operation.equals("-")) {
            result = subtract(a, b);
        } else if (operation.equals("*")) {
            result = multiply(a, b);
        } else if (operation.equals("/")) {
            result = divide(a, b);
            if (b == 0) {
                hasError = true;
            }
        } else {
            System.out.println("Error: Invalid operation");
            hasError = true;
        }
        
        if (!hasError) {
            System.out.println("Result: " + result);
        }
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }   
    public static int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return 0;
        }
        return a / b;
    }
}
