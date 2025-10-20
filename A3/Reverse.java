public class Reverse {
    public static void main(String[] args) {
    // reverse an array of integers
    int[] arr = {1, 2, 3, 4, 5};
    int[] reversed = reverseArray(arr);
    for (int i = 0; i < reversed.length; i++) {
        System.out.println(reversed[i]);
    }
}

public static int[] reverseArray(int[] arr) {
    int[] reversed = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        reversed[i] = arr[arr.length - i - 1];
    }
    return reversed;
}
