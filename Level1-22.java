import java.util.*;

public class Level1 {
    private static int howManyTimes(int index, String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(index)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean checker(int index, Integer[] counters){
        counters[index] = counters[index] - 1;
        int ref = counters[0];
        if (counters[0] == 0) ref = counters[1];
        for (int i = 0; i < counters.length; i++){
            if (counters[i] != ref && counters[i] != 0){
                counters[index] = counters[index] + 1;
                return false;
            }
        }
        return true;
    }

    public static boolean SherlockValidString(String s) {
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> counters = new ArrayList<>();

        int counter;
        for (int i = 0; i < s.length(); i++) {
            counter = howManyTimes(i, s);
            if (!chars.contains(s.charAt(i))){
                chars.add(s.charAt(i));
                counters.add(counter);
            }
        }

        boolean res = true;
        for (int i = 0; i < counters.size() - 1; i++) {
            if (!counters.get(i).equals(counters.get(i + 1))) {
                res = false;
                break;
            }
        }
        if (res) return true;

        Integer[] list = counters.toArray(new Integer[0]);
        boolean condition;
        for (int i = 0; i < list.length; i++){
            condition = checker(i, list);
            if (condition) {
                return true;
            }
        }
        return false;
    }
}
