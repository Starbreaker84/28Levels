public class Level1 {
    private static int pow(int value, int powValue) {
        int result = 1 ;
        for (int i = 1; i <= powValue; i++) {
            result *= value;
        }
        return result;
    }

    private static int translator(int number, int base) {
        String num = Integer.toString(number);
        int digit = num.length();
        int converted = 0;
        for (int i = 0; i < digit; i++) {
            converted += Character.getNumericValue(num.charAt(i)) * pow(base, digit - 1 - i);
        }
        return converted;
    }

    public static int [] UFO(int N, int [] data, boolean octal) {
        int base = 16;
        if (octal) base = 8;
        for (int i = 0; i < N; i++) {
            data[i] = translator(data[i], base);
        }
        return data;
    }
}
