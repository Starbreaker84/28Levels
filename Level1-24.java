public class Level1 {
    private static void turn(char[][] matrix, int M, int N){
        char temp1;
        char temp2;
        int cycles = M / 2;
        if (N < M) cycles = N / 2;
        for (int i = 0; i < cycles; i++){
            temp1 = matrix[i][i];
            for (int row = i; row < N - 1 - i; row++) {
                temp2 = matrix[i][row + 1];
                matrix[i][row + 1] = temp1;
                temp1 = temp2;
            }
            for (int col = i + 1; col < M - 1 - i; col++) {
                temp2 = matrix[col][N - 1 - i];
                matrix[col][N - 1 - i] = temp1;
                temp1 = temp2;
            }
            for (int backRow = (N - 1 - i); backRow >= i; backRow-- ) {
                temp2 = matrix[M - i - 1][backRow];
                matrix[M - i - 1][backRow] = temp1;
                temp1 = temp2;
            }
            for (int backCol = (M - 2 - i); backCol > i; backCol--) {
                temp2 = matrix[backCol][i];
                matrix[backCol][i] = temp1;
                temp1 = temp2;
            }
            matrix[i][i] = temp1;
        }
    }
    private static char[][] toMatrix(String Matrix[], int M, int N){
        char[][] charMatrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                charMatrix[i][j] = Matrix[i].charAt(j);
            }
        }
        return charMatrix;
    }
    public static void MatrixTurn(String Matrix[], int M, int N, int T) {
        char[][] matrix = toMatrix(Matrix, M, N);
        for (int i = 0; i < T; i++) turn(matrix, M, N);
        for (int i = 0; i < M; i++) {
            StringBuilder bld = new StringBuilder();
            for (int j = 0; j < N; j++) {
                bld.append(matrix[i][j]);
            }
            Matrix[i] = bld.toString();
        }
    }
}
