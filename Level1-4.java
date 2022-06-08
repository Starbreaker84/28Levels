public class Task4 {
    public static int [] MadMax(int N, int [] Tele) {
        if (N == 1) return Tele;
        int currentNumber;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < N - 1; i++) {
                if (Tele[i] > Tele[i + 1]) {
                    currentNumber = Tele[i];
                    Tele[i] = Tele[i + 1];
                    Tele[i + 1] = currentNumber;
                    changed = true;
                }
            }
        }
        for (int i = N / 2, j = 1; i <= N - j; i++, j++) {
            currentNumber = Tele[i];
            Tele[i] = Tele[N - j];
            Tele[N - j] = currentNumber;
        }
        return Tele;
    }
}
