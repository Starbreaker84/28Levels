public class Level1 {
    public static String PatternUnlock(int N, int [] hits) {
        String code = "";
        if (N == 1) {
            return code;
        }
        double line = 0;
        for (int i = 1; i < N; i++) {
            int checker = hits[i] + hits[i - 1];
            if ((checker == 6 || checker == 8) || ((checker == 9 || checker == 11) && (hits[i] >= 7 || hits[i - 1] >= 7))) {
                line += Math.sqrt(2);
            } else line += 1;
        }
        String str = String.format("%.5f", line);
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != '0' && str.charAt(i) != '.') {
                code = code + str.charAt(i);
            }
        }
        return code;
    }
}
