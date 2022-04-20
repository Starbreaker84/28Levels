public class Level1 {
    private static String getPattern (String line) {
        StringBuilder bld = new StringBuilder();
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == '*') break;
            bld.append(line.charAt(i));
        }
        return bld.toString();
    }

    public static boolean LineAnalysis(String line) {
        String pattern = getPattern(line);
        StringBuilder bld = new StringBuilder();
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == '*' && !bld.toString().equals(pattern)) {
                return false;
            }
            if (line.charAt(i) == '*') {
                bld = new StringBuilder();
                continue;
            }
            bld.append(line.charAt(i));
        }
        return true;
    }
}
