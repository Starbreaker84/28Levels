public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
        int days = 0;
        int [][] battlefield = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                battlefield[i][j] = 0;
            }
        }
        int target = N * M;
        int currentState = 0;
        while (currentState < target) {
            days++;
            if (days == 1) {
                for (int i = 0; i < L * 2; i++) {
                    if (i % 2 != 0) battlefield[battalion[i - 1] - 1][battalion[i] - 1] = 1;
                }
            }
            else {
                currentState = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (battlefield[i][j] == 1) {
                            if ((i - 1) >= 0 && battlefield[i - 1][j] == 0) battlefield[i - 1][j] = 2;
                            if ((i + 1) < N && battlefield[i + 1][j] == 0) battlefield[i + 1][j] = 2;
                            if ((j - 1) >= 0 && battlefield[i][j - 1] == 0) battlefield[i][j - 1] = 2;
                            if ((j + 1) < M && battlefield[i][j + 1] == 0) battlefield[i][j + 1] = 2;
                        }
                    }
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (battlefield[i][j] == 2) {
                            battlefield[i][j] = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (battlefield[i][j] == 1) currentState++;
                }
            }
        }
        return days;
    }
}
