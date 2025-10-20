public class Hopscotch {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n == 0) {
            return;
        }
        for (int i=1; i<=n; i+=3) {
            System.out.print(i + " ");
        }
        for (int i=2; i<=n; i+=3) {
            System.out.print(i + " ");
        }
        for (int i=3; i<=n; i+=3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
