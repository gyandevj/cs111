public class FireboyAndWatergirl {

    private static int FIREBOY   = 1;
    private static int WATERGIRL = 2;

    public static void nextStep(char[][] a, int b, int c, boolean[][] d, int e) {
        if (b < 0 || b >= a.length || c < 0 || c >= a[0].length) return;
        if (d[b][c]) return;
        if (a[b][c] == 'G') return;
        if (e == FIREBOY && a[b][c] == 'W') return;
        if (e == WATERGIRL && a[b][c] == 'F') return;
        
        d[b][c] = true;
        nextStep(a, b + 1, c, d, e);
        nextStep(a, b, c - 1, d, e);
        nextStep(a, b - 1, c, d, e);
        nextStep(a, b, c + 1, d, e);
    }

    public static void main(String[] args)
    {
         if ( args.length < 1 ) {
             System.out.println("Error: FireboyAndWatergirl requires a file name as the first command line argument!");
             return;
        }

        String file = (args[0]);
        StdIn.setFile(file);
        int d = StdIn.readInt();
        
        char[][] maze = new char[d][d];

        boolean[][] fireboyVisited = new boolean[d][d];
        boolean[][] watergirlVisited = new boolean[d][d];

        for (int row = 0; row < d; row++) {
            for (int col = 0; col < d; col++) {
                StdIn.readChar();
                maze[row][col] = StdIn.readChar();
            }
        }

        nextStep(maze, 0, 0, fireboyVisited, FIREBOY);
        
        System.out.println("Fireboy Visited:");
        for (int row = 0; row < d; row++) {
            for (int col = 0; col < d; col++) {
                if (fireboyVisited[row][col]) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
        nextStep(maze, 0, 0, watergirlVisited, WATERGIRL);

        System.out.println("Watergirl Visited:");
        for (int row = 0; row < d; row++) {
            for (int col = 0; col < d; col++) {
                if (watergirlVisited[row][col]) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        
    }
}