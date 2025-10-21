import java.util.Random;

public class BlockBlast {

    public static void main(String[] args) {
        // Define different block shapes as 2D boolean arrays
        // true represents a filled cell, false represents empty space
        boolean[][] verticalLine = { { true }, { true }, { true }, { true } };
        boolean[][] smallSquare = { { true, true }, { true, true } };
        boolean[][] bigSquare = { { true, true, true }, { true, true, true }, { true, true, true } };
        boolean[][] zShape = { { false, true }, { true, true }, { true, false } };
        boolean[][] tShape = { { true, true, true }, { false, true, false } };
        boolean[][] horizontalLine = { { true, true, true } };
        
        // Store all block shapes in an array
        boolean[][][] blocks = { verticalLine, smallSquare, bigSquare, zShape, tShape, horizontalLine };
        int numBlocks = blocks.length;
        boolean[][] gameGrid = null;

        // Get grid size from command line argument and initialize game grid
        int gridSize = Integer.parseInt(args[0]);
        gameGrid = new boolean[gridSize][gridSize];

        // Game variables
        boolean[][] b;        // current block being placed
        boolean a = true;     // game active flag
        int s = 0;           // score
        Random rand = new Random(2);  // random number generator with seed 2
        int i = 0;           // block index
        // Main game loop - continues while game is active
        while (a) {
            // Randomly select a block (0-4, excluding the last block)
            i = rand.nextInt(5);
            b = blocks[i];

            // Try to place the current block on the grid
            boolean p = false;  // placed flag
            
            // Try every possible position on the grid
            for (int r = 0; r <= gameGrid.length - b.length; r++) {
                if (p) break;  // exit if block already placed
                for (int c = 0; c <= gameGrid[0].length - b[0].length; c++) {
                    // Check if block can be placed at this position
                    boolean f = true;  // fit flag
                    for (int x = 0; x < b.length; x++) {
                        for (int y = 0; y < b[x].length; y++) {
                            // If block cell is filled and grid cell is already occupied, can't place
                            if (b[x][y] && gameGrid[r + x][c + y]) {
                                f = false;
                                break;
                            }
                        }
                        if (!f) break;
                    }   
                    // If block fits at this position, place it
                    if (f) {
                        for (int x = 0; x < b.length; x++) {
                            for (int y = 0; y < b[x].length; y++) {
                                if (b[x][y]) {
                                    gameGrid[r + x][c + y] = true;
                                }
                            }
                        }
                        p = true;  // mark as placed
                        break;
                    }
                }
            }
            // If block couldn't be placed anywhere, end the game
            if (!p) {
                a = false;
                break;
            }
            // Check for completed rows and columns after placing block
            boolean[] cr = new boolean[gameGrid.length];    // completed rows
            boolean[] cc = new boolean[gameGrid[0].length];  // completed columns
            
            // Check each row to see if it's completely filled
            for (int r = 0; r < gameGrid.length; r++) {
                boolean rc = true;  // row complete flag
                for (int c = 0; c < gameGrid[r].length; c++) {
                    if (!gameGrid[r][c]) {
                        rc = false;
                        break;
                    }
                }
                cr[r] = rc;
            }
            
            // Check each column to see if it's completely filled
            for (int c = 0; c < gameGrid[0].length; c++) {
                boolean col = true;  // column complete flag
                for (int r = 0; r < gameGrid.length; r++) {
                    if (!gameGrid[r][c]) {
                        col = false;
                        break;
                    }
                }
                cc[c] = col;
            }        
            
            // Clear completed rows by setting all cells to false
            for (int r = 0; r < gameGrid.length; r++) {
                if (cr[r]) {
                    for (int c = 0; c < gameGrid[r].length; c++) {
                        gameGrid[r][c] = false;
                    }
                }
            }         
            
            // Clear completed columns by setting all cells to false
            for (int c = 0; c < gameGrid[0].length; c++) {
                if (cc[c]) {
                    for (int r = 0; r < gameGrid.length; r++) {
                        gameGrid[r][c] = false;
                    }
                }
            }
            
            // Calculate score based on lines cleared
            int l = 0;  // lines cleared counter
            for (boolean rc : cr) {
                if (rc) l++;
            }
            for (boolean col : cc) {
                if (col) l++;
            }
            s += l * 10;  // add 10 points per line cleared
        }
        
        // Display the final game board
        System.out.println("Game Board:");
        for (int r = 0; r < gameGrid.length; r++) {
            for (int c = 0; c < gameGrid[r].length; c++) {
                if (gameGrid[r][c]) {
                    System.out.print("X ");  // X represents filled cells
                } else {
                    System.out.print("_ ");  // _ represents empty cells
                }
            }
            System.out.println();
        }
        
        // Display the final score
        System.out.println("Final Score: " + s);
    }
}