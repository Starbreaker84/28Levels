public class Level1 {
    private static String [] splitter(int len, String s) {
        String [] words = s.split(" ");
        int counter = words.length;
        for (String word : words) {
            if (word.length() > len) {
                counter++;
            }
        }
        String [] newWords = new String[counter];
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > len) {
                newWords[j] = words[i].substring(0, len);
                newWords[j + 1] = words[i].substring(len);
                j += 2;
            } else {
                newWords[j] = words[i];
                j++;
            }
        }
        return newWords;
    }
    private static String [] stringCutter(int len, String [] words) {
        int counter = 0;
        String str = "";
        for (int i = 0; i < words.length; i++) {
            str += words[i];
            if (str.length() < len) {
                if (i == words.length - 1) {
                    counter++;
                } else {
                    str += " ";
                }
            } else if (str.length() == len) {
                counter++;
                str = "";
            } else {
                counter++;
                str = "";
                i--;
            }
        }
        String [] strings = new String[counter];
        str = "";
        String str0 = "";
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            str += words[i];
            if (str.length() < len) {
                if (i == words.length - 1) {
                    strings[j] = str;
                } else {
                    str0 = str;
                    str += " ";
                }
            } else if (str.length() == len) {
                strings[j] = str;
                j++;
                str = "";
                str0 = str;
            } else {
                strings[j] = str0;
                j++;
                str = "";
                str0 = str;
                i--;
            }
        }
        return strings;
    }

    private static int [] isInString(String [] strings, String subs) {
        int [] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (subContains(strings[i], subs)) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }
    private static boolean subContains(String s1, String s2) {
        int len = s2.length();
        int start = 0;
        if (s1.contains(s2)) {
            start = s1.indexOf(s2);
            if (start == 0 || (start > 0 && s1.charAt(start - 1) == ' ')){
                int startlen = start + len;
                int s1length = s1.length();
                if ((start + len == s1.length()) || (start + len < s1.length() && (s1.charAt(start + len) == ' ' || s1.charAt(start + len) == '.'))) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int [] WordSearch(int len, String s, String subs) {
        String [] words = splitter(len, s);
        String [] strings = stringCutter(len, words);
        int [] result = isInString(strings, subs);
        return result;
    }
}
