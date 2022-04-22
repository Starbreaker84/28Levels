public class Level1 {
    private static void sorter(String[] items){
        boolean xchange = true;
        String shadow;
        String[] str;
        while (xchange) {
            xchange = false;
            for (int i = 0; i < items.length - 1; i++) {
                str = items[i].split(" ");
                int num1= Integer.parseInt(str[1]);
                str = items[i + 1].split(" ");
                int num2 = Integer.parseInt(str[1]);
                if (num1 < num2) {
                    shadow = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = shadow;
                    xchange = true;
                }
            }
        }
        String [] str1;
        String [] str2;
        for (int i = 0; i < items.length - 1; i++) {
            str1 = items[i].split(" ");
            str2 = items[i + 1].split(" ");
            if (items[i].compareTo(items[i + 1]) > 0 && str1[1].equals(str2[1])) {
                shadow = items[i];
                items[i] = items[i + 1];
                items[i + 1] = shadow;
            }
        }
    }

    private static String[] merger(String[] items){
        String [] str1;
        String [] str2;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals("")) continue;
            str1 = items[i].split(" ");
            for (int j = 0; j < items.length; j++){
                if (i == j) continue;
                str2 = items[j].split(" ");
                if (str1[0].equals(str2[0])) {
                    int sum = Integer.parseInt(str1[1]) + Integer.parseInt(str2[1]);
                    items[i] = str1[0] + " " + sum;
                    items[j] = "";
                }
            }
        }
        int counter = 0;
        for (String item : items) {
            if (!item.equals("")) counter++;
        }
        String [] mergedItems = new String [counter];
        counter = 0;
        for (String item : items) {
            if (!item.equals("")) {
                mergedItems[counter] = item;
                counter++;
            }
        }
        return mergedItems;
    }

    public static String [] ShopOLAP(int N, String [] items) {
        String [] mergedItems = merger(items);
        sorter(mergedItems);
        return mergedItems;
    }
}
