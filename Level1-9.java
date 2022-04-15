public class Level1 {
    private static String encoding(String s) {
        s = s.replace(" ", "");
        int sLen = s.length();
        int rows = (int) Math.sqrt(sLen);
        int cols = rows + 1;
        while (rows * cols < sLen) {
            rows++;
        }
        char [][] matrix = new char[rows][cols];
        int chars = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (chars >= sLen) {
                    matrix[i][j] = ' ';
                } else matrix[i][j] = s.charAt(chars);
                chars++;
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++){
                if (matrix[i][j] != ' ') {
                    sBuilder.append(matrix[i][j]);
                }
            }
            sBuilder.append(" ");
        }
        s = sBuilder.toString();
        return s.trim();
    }
    private static String decoding(String s){
        String[] words = s.split(" ");
        int sLen =s.replace(" ", "").length();
        int rows = (int) Math.sqrt(sLen);
        int cols = rows + 1;
        while (rows * cols < sLen) {
            rows++;
        }
        char [][] matrix = new char[rows][cols];
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++){
                if (i >= words[j].length()) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = words[j].charAt(i);
                }
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++){
                if (matrix[i][j] != ' ') {
                    sBuilder.append(matrix[i][j]);
                }
            }
        }
        s = sBuilder.toString();
        return s;
    }

    public static String TheRabbitsFoot(String s, boolean encode) {
        if (encode) {
            return encoding(s);
        } else {
            return decoding(s);
        }
    }
}
