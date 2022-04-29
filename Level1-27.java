public class Level1 {
    private static boolean way1(int F[], int N, int entry){
        int index = N - 1;
        for (int i = entry + 1; i < N - 1; i++){
            if (F[i] > F[i + 1]) {
                index = i + 1;
                break;
            }
        }
        F[index] = F[index] + F[entry];
        F[entry] = F[index] - F[entry];
        F[index] = F[index] - F[entry];
        for (int i = 0; i < N - 1; i++){
            if (F[i] > F[i + 1]) return false;
        }
        return true;
    }

    private static boolean way2(int F[], int N, int entry){
        int index = N - 1;
        for (int i = entry + 1; i < N - 1; i++){
            if (F[i] < F[i + 1]) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < (index - entry) / 2; i++){
            F[index - i] = F[index - i] + F[entry + i];
            F[entry + i] = F[index - i] - F[entry + i];
            F[index - i] = F[index - i] - F[entry + i];
        }
        for (int i = 0; i < N - 1; i++){
            if (F[i] > F[i + 1]) return false;
        }
        return true;
    }

    public static boolean Football(int F[], int N){
        int flag = 0;
        int entry = 0;
        for (int i = 0; i < N - 1; i++){
            if (F[i] > F[i + 1]){
                flag = 1;
                entry = i;
                break;
            }
        }
        if (flag == 1) return way1(F, N, entry) || way2(F, N, entry);
        return false;
    }
}
