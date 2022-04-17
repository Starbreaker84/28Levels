public class Level1 {
    private static String biggest(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s1;
        }
        if (s1.length() < s2.length()) {
            return s2;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (Character.getNumericValue(s2.charAt(i)) > Character.getNumericValue(s1.charAt(i))) {
                return s2;
            }
        }
        return s1;
    }

    private static String minus(String big, String small) {
        String result = "";
        int num1;
        int num2;
        int inMind = 0;
        int minus;
        for (int i = small.length() - 1; i >=0; i--) {
            num1 = Character.getNumericValue(big.charAt(big.length() - small.length() + i));
            num2 = Character.getNumericValue(small.charAt(i));
            if (num1 >= num2) {
                minus = num1 - inMind - num2;
                inMind = 0;
            } else if (num1!= 0) {
                minus = num1 + 10 - num2;
                inMind = 1;
            } else {
                minus = num1 + 10 - inMind - num2;
            }
            result = minus + result;
        }
        for (int i = big.length() - small.length() - 1; i >=0; i--) {
            result = big.charAt(i) + result;
        }
        String finalResult = "";
        boolean flag = true;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0' && flag) {
                continue;
            }
            flag = false;
            finalResult += result.charAt(i);
        }
        return finalResult;
    }

    public static String BigMinus(String s1, String s2) {
        String big = biggest(s1, s2);
        String small;
        if (big.equals(s1)) {
            small = s2;
        } else {
            small = s1;
        }
        if (big.equals(small)) {
            return "0";
        }
        return minus(big, small);
    }
}
