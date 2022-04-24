public class Level1 {
    private static void replacer(int i, int entryIndex, int[] symbols) {
        int shadow;
        shadow = symbols[i];
        symbols[i] = symbols[entryIndex];
        symbols[entryIndex] = shadow;
    }

    private static int getGreaterPoint(int index, int[] symbols) {
        int currentNum = symbols[index];
        int greaterIndex = -1;
        int greaterNumber = 0;
        for (int i = symbols.length - 1; i > index; i--) {
            if (symbols[i] > currentNum && greaterIndex == -1) {
                greaterIndex = i;
                greaterNumber = symbols[i];
            }
            if (symbols[i] > currentNum && greaterIndex != -1 && symbols[i] < greaterNumber) {
                greaterIndex = i;
                greaterNumber = symbols[i];
            }
        }
        return greaterIndex;
    }

    private static int getSmallerPoint(int index, int[] symbols){
        int currentNum = symbols[index];
        int smallerIndex = -1;
        int smallerNumber = 0;
        for (int i = symbols.length - 1; i > index; i--) {
            if (symbols[i] < currentNum && smallerIndex == -1) {
                smallerIndex = i;
                smallerNumber = symbols[i];
            }
            if (symbols[i] < currentNum && smallerIndex != -1 && symbols[i] < smallerNumber) {
                smallerIndex = i;
                smallerNumber = symbols[i];
            }
        }
        return smallerIndex;
    }
    private static int[] stringToIntSymbols(String input){
        int[] symbols = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            symbols[i] = input.charAt(i);
        }
        return symbols;
    }

    private static String intToString(int [] symbols) {
        StringBuilder bld = new StringBuilder();
        for (int num : symbols) {
            bld.append((char) num);
        }
        return bld.toString();
    }

    public static String BiggerGreater(String input) {
        int[] symbols = stringToIntSymbols (input);
        int finalIndex = -1;
        int entryIndex = -1;
        for (int i = symbols.length - 2; i >= 0; i--) {
            entryIndex = getGreaterPoint(i, symbols);
            if (entryIndex != -1) {
                finalIndex = i + 1;
                replacer(i, entryIndex, symbols);
                break;
            }
        }
        if (entryIndex == -1) {
            return "";
        }
        for (int i = finalIndex; i < symbols.length - 1; i++) {
            entryIndex = getSmallerPoint(i, symbols);
            if (entryIndex != -1) {
                replacer(i, entryIndex, symbols);
            }
        }
        return intToString(symbols);
    }
}
