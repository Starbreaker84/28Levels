public class Level1 {
    public static int [] MadMax(int N, int [] Tele) {
        if (N == 1) return Tele;
        int item;
        boolean xchange = true;
        while (xchange) {
            xchange = false;
            for (int i = 0; i < N - 1; i++) {
                if (Tele[i] > Tele[i + 1]) {
                    item = Tele[i];
                    Tele[i] = Tele[i + 1];
                    Tele[i + 1] = item;
                    xchange = true;
                }
            }
        }
        int j = 1;
        for (int i = N / 2; i <= N - j; i++) {
            item = Tele[i];
            Tele[i] = Tele[N - j];
            Tele[N - j] = item;
            j++;
        }
        return Tele;
    }
}
