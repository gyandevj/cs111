//write a program that reads in a number n in command line and then creates a horrizontal pyramid of height N using *
public class Main {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*"); // yes but then it also has to decreasing downwards to n
			}
			System.out.println();
		}
		for (int i = n-1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}