public class Level1 {
    public static int Unmanned(int L, int N, int [][] track) {
        int time = 0;
        int distance = 0;
        for (int i = 0; i < N; i++) {
            time += track[i][0] - distance;
            distance += track[i][0] - distance;
            int loop = track[i][1] + track[i][2];
            int res = time % loop;
            if (res < track[i][1]) {
                time += track[i][1] - res;
            }
        }
        time += L - distance;
        return time;
    }
}
