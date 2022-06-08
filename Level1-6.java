public class Task6 {
    public static String PatternUnlock(int N, int [] hits) {
        String unlockCode = "";
        if (N == 1) {
            return unlockCode;
        }
        double lengthOfUnlockLine = 0;
        for (int i = 1; i < N; i++) {
            int sumOfBesideDigits = hits[i] + hits[i - 1];
            if ((sumOfBesideDigits == 6 || sumOfBesideDigits == 8) || ((sumOfBesideDigits == 9 || sumOfBesideDigits == 11) && (hits[i] >= 7 || hits[i - 1] >= 7))) {
                lengthOfUnlockLine += Math.sqrt(2);
            } else lengthOfUnlockLine += 1;
        }
        unlockCode = Integer.toString((int) Math.round(lengthOfUnlockLine * 100000)).replace("0", "");
        return unlockCode;
    }
}
