import java.util.Random;

public class BlockBlast {

    public static void main(String[] args) {
        boolean[][] verticalLine = { { true }, { true }, { true }, { true } };
        boolean[][] smallSquare = { { true, true }, { true, true } };
        boolean[][] bigSquare = { { true, true, true }, { true, true, true }, { true, true, true } };
        boolean[][] zShape = { { false, true }, { true, true }, { true, false } };
        boolean[][] tShape = { { true, true, true }, { false, true, false } };
        boolean[][] horizontalLine = { { true, true, true } };
        boolean[][][] blocks = { verticalLine, smallSquare, bigSquare, zShape, tShape, horizontalLine };
        int numBlocks = blocks.length;
        boolean[][] gameGrid = null;

        int gridSize = Integer.parseInt(args[0]);
        gameGrid = new boolean[gridSize][gridSize];

        boolean[][] b;
        boolean a = true;
        int s = 0;
        Random rand = new Random(2);
        int i = 0;
        //currenblock - b
        //GA - a
        //score - s
        //placed - p
        //br,bc - x,y
        //completed rows - cr
        //completed columns - cc
        //l - lines cleared
        //col completed - col
        while (a) {
            i = rand.nextInt(5);
            b = blocks[i];

            boolean p = false;
            for (int r = 0; r <= gameGrid.length - b.length; r++) {
                if (p) break;
                for (int c = 0; c <= gameGrid[0].length - b[0].length; c++) {
                    boolean f = true;
                    for (int x = 0; x < b.length; x++) {
                        for (int y = 0; y < b[x].length; y++) {
                            if (b[x][y] && gameGrid[r + x][c + y]) {
                                f = false;
                                break;
                            }
                        }
                        if (!f) break;
                    }   
                    if (f) {
                        for (int x = 0; x < b.length; x++) {
                            for (int y = 0; y < b[x].length; y++) {
                                if (b[x][y]) {
                                    gameGrid[r + x][c + y] = true;
                                }
                            }
                        }
                        p = true;
                        break;
                    }
                }
            }
            if (!p) {
                a = false;
                break;
            }
            boolean[] cr = new boolean[gameGrid.length];
            boolean[] cc = new boolean[gameGrid[0].length];
            
            for (int r = 0; r < gameGrid.length; r++) {
                boolean rc = true;
                for (int c = 0; c < gameGrid[r].length; c++) {
                    if (!gameGrid[r][c]) {
                        rc = false;
                        break;
                    }
                }
                cr[r] = rc;
            }
            for (int c = 0; c < gameGrid[0].length; c++) {
                boolean col = true;
                for (int r = 0; r < gameGrid.length; r++) {
                    if (!gameGrid[r][c]) {
                        col = false;
                        break;
                    }
                }
                cc[c] = col;
            }        
            for (int r = 0; r < gameGrid.length; r++) {
                if (cr[r]) {
                    for (int c = 0; c < gameGrid[r].length; c++) {
                        gameGrid[r][c] = false;
                    }
                }
            }         
            for (int c = 0; c < gameGrid[0].length; c++) {
                if (cc[c]) {
                    for (int r = 0; r < gameGrid.length; r++) {
                        gameGrid[r][c] = false;
                    }
                }
            }
            int l = 0;
            for (boolean rc : cr) {
                if (rc) l++;
            }
            for (boolean col : cc) {
                if (col) l++;
            }
            s += l * 10;
        }
        System.out.println("Game Board:");
        for (int r = 0; r < gameGrid.length; r++) {
            for (int c = 0; c < gameGrid[r].length; c++) {
                if (gameGrid[r][c]) {
                    System.out.print("X ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println("Final Score: " + s);
    }
}