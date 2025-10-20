public class Main {
    // sum of number of perimeter in a 2d array
    // Function to compute the sum of the perimeters in a 2D array (matrix)
    public static int sumPerimeter(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int sum = 0;
        
        // top row
        for (int j = 0; j < n; j++) sum += matrix[0][j];
        // bottom row (if more than one row)
        if (m > 1) {
            for (int j = 0; j < n; j++) sum += matrix[m-1][j];
        }
        // left column (excluding first and last row)
        for (int i = 1; i < m-1; i++) sum += matrix[i][0];
        // right column (excluding first and last row)
        if (n > 1) {
            for (int i = 1; i < m-1; i++) sum += matrix[i][n-1];
        }
        return sum;
    }
}
