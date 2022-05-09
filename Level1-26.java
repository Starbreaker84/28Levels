import java.util.*;

public class Level1 {
    private static boolean scanner(int i, int j, String village){
        int counter = 0;
        for (int k = i + 1; k < j; k++) {
            if (village.charAt(k) == '=') counter++;
        }
        return counter == 3;
    }

    public static boolean white_walkers(String village){
        ArrayList<Boolean> groups = new ArrayList<>();
        int flag = 0;
        int num1 = 0;
        int index1 = 0;
        int index2 = 0;
        int num2 = 0;
        for (int i = 0; i < village.length(); i++){
            char symbol = village.charAt(i);
            if (symbol >= 49 && symbol <=57 && flag == 0){
                num1 = Integer.parseInt(String.valueOf(village.charAt(i)));
                index1 = i;
                flag = 1;
                continue;
            }
            if (symbol >= 49 && symbol <=57 && flag == 1){
                num2 = Integer.parseInt(String.valueOf(village.charAt(i)));
                index2 = i;
                flag = 2;
            }
            if (flag == 2 && num1 + num2 == 10) groups.add(scanner(index1, index2, village));
            if (flag == 2) {
                flag = 1;
                num1 = Integer.parseInt(String.valueOf(village.charAt(i)));
                index1 = i;
            }
        }
        int counter = 0;
        for (Boolean group : groups) {
            if (!group) break;
            counter++;
        }
        return counter == groups.size() && counter != 0;
    }
}
