public class Level1 {
    private static int[][] toMatrix(int H, int W, String [] tree) {
        int[][] realTree = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (tree[i].charAt(j) == '.') realTree[i][j] = 0;
                if (tree[i].charAt(j) == '+') realTree[i][j] = 1;
            }
        }
        return realTree;
    }

    private static String[] toString(int H, int W, int[][] realTree) {
        String [] tree = new String [H];
        for (int i = 0; i < H; i++) {
            StringBuilder bld = new StringBuilder();
            for (int j = 0; j < W; j++) {
                if (realTree[i][j] == 0) bld.append('.');
                if (realTree[i][j] != 0) bld.append('+');
            }
            tree[i] = bld.toString();
        }
        return tree;
    }

    private static void grow(int H, int W, int[][] realTree){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++){
                realTree[i][j] += 1;
            }
        }
    }

    private static void dying(int H, int W, int[][] realTree){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++){
                if (realTree[i][j] >= 3) {
                    death(i, j, H, W, realTree);
                    realTree[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++){
                if (realTree[i][j] == -1) realTree[i][j] = 0;
            }
        }
    }

    private static void death(int i, int j, int H, int W,int [][] realTree){
        if (i - 1 >= 0) realTree[i - 1][j] = -1;
        if (i + 1 <= H - 1) realTree[i + 1][j] = -1;
        if (j - 1 >= 0) realTree[i][j - 1] = -1;
        if (j + 1 <= W - 1) realTree[i][j + 1] = -1;
    }

    public static String [] TreeOfLife(int H, int W, int N, String [] tree) {
        int[][] realTree = toMatrix(H, W, tree);
        for (int year = 0; year < N; year++) {
            if (year % 2 == 0) {
                grow(H, W, realTree);
            }
            if (year % 2 != 0) {
                grow(H, W, realTree);
                dying(H, W, realTree);
            }
        }
        return toString(H, W, realTree);
    }
}
