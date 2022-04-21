public class Level1 {
    private static void swing (int [] data, int pos, int i) {
        while (pos != i) {
            if (pos - 2 >= i){
                int shadow = data[pos - 2];
                data[pos - 2] = data [pos];
                data[pos] = data[pos - 1];
                data[pos - 1] = shadow;
                pos = pos - 2;
                continue;
            }
            int shadow = data[pos - 1];
            data[pos - 1] = data [pos];
            data[pos] = data[pos + 1];
            data[pos + 1] = shadow;
            pos = pos - 1;
        }
    }

    public static boolean MisterRobot(int N, int [] data){
        for (int i = 0; i < N - 2; i++) {
            int number = i + 1;
            if (data[i] == number) continue;
            int pos = 0;
            for (int j = number; j < N; j++) {
                if (data[j] == number) {
                    pos = j;
                    break;
                }
            }
            swing(data, pos, i);
        }
        return data[N - 2] == data[N - 3] + 1;
    }
}
