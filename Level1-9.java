public class Task9 {
    private static String encoding(String stringForEncode) {
        stringForEncode = stringForEncode.replace(" ", "");
        int stringForEncodeLength = stringForEncode.length();
        int numberOfRowsInMatrix = (int) Math.sqrt(stringForEncodeLength);
        int numberOfColumnsInMatrix = numberOfRowsInMatrix + 1;
        while (numberOfRowsInMatrix * numberOfColumnsInMatrix < stringForEncodeLength) {
            numberOfRowsInMatrix++;
        }
        char [][] matrix = new char[numberOfRowsInMatrix][numberOfColumnsInMatrix];
        int indexOfCharInInputString = 0;
        for (int i = 0; i < numberOfRowsInMatrix; i++) {
            for (int j = 0; j < numberOfColumnsInMatrix; j++){
                if (indexOfCharInInputString >= stringForEncodeLength) {
                    matrix[i][j] = ' ';
                } else matrix[i][j] = stringForEncode.charAt(indexOfCharInInputString);
                indexOfCharInInputString++;
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int j = 0; j < numberOfColumnsInMatrix; j++) {
            for (int i = 0; i < numberOfRowsInMatrix; i++){
                if (matrix[i][j] != ' ') {
                    sBuilder.append(matrix[i][j]);
                }
            }
            sBuilder.append(" ");
        }
        String encodedString = sBuilder.toString();
        return encodedString.trim();
    }
    private static String decoding(String stringForDecode){
        String[] wordsFromStringForDecode = stringForDecode.split(" ");
        int stringForDecodeLength = stringForDecode.replace(" ", "").length();
        int numberOfRowsInMatrix = (int) Math.sqrt(stringForDecodeLength);
        int numberOfColumnsInMatrix = numberOfRowsInMatrix + 1;
        while (numberOfRowsInMatrix * numberOfColumnsInMatrix < stringForDecodeLength) {
            numberOfRowsInMatrix++;
        }
        char [][] matrix = new char[numberOfRowsInMatrix][numberOfColumnsInMatrix];
        for (int j = 0; j < numberOfColumnsInMatrix; j++) {
            for (int i = 0; i < numberOfRowsInMatrix; i++){
                if (i >= wordsFromStringForDecode[j].length()) {
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = wordsFromStringForDecode[j].charAt(i);
                }
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < numberOfColumnsInMatrix; i++) {
            for (int j = 0; j < numberOfRowsInMatrix; j++){
                if (matrix[i][j] != ' ') {
                    sBuilder.append(matrix[i][j]);
                }
            }
        }
        String decodedString = sBuilder.toString();
        return decodedString;
    }

    public static String TheRabbitsFoot(String s, boolean encode) {
        if (encode) {
            return encoding(s);
        } else {
            return decoding(s);
        }
    }
}
