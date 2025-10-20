public class GlassBridge {
    public static void main(String[] args) {
        boolean[][] b = new boolean[2][10];
        char[] p = new char[10];

        for (int i = 0; i < 10; i++) {
            b[0][i] = Boolean.parseBoolean(args[i * 2]);
            b[1][i] = Boolean.parseBoolean(args[i * 2 + 1]);
        }

        for (int i = 0; i < 10; i++) {
            p[i] = args[20 + i].charAt(0);
        }

        boolean safe = true;
        for (int i = 0; i < 10; i++) {
            int r;
            if (p[i] == 'L') {
                r = 0;
            } else {
                r = 1;
            }
            if (!b[r][i]) {
                safe = false;
                break;
            }
        }
        if (safe) {
            System.out.println("safe");
        } else {
            System.out.println("unsafe");
        }
    }
}