public class Level1 {
    public static int squirrel(int n) {
        double fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
            while (fact >= 10) {
                fact = fact / 10;
            }
        }
        return (int) fact;
    }
}
