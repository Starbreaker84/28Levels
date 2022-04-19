public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        if (W1 < W2 || H1 < H2) return false;
        String [] array1 = S1.split(" ");
        String [] array2 = S2.split(" ");
        int counter = 0;
        int row;
        boolean flag = false;
        for (int i = 0; i < H1; i++) {
            if (i == H1 - 1 && H2 > 1) break;
            for (int id = 0; id < W1; id++) {
                int position = array1[i].indexOf(array2[0], id);
                if (position != -1) {
                    id = position;
                    counter++;
                    flag = true;
                    row = i + 1;
                    for (int j = 1; j < H2; j++) {
                        if (row == H1) break;
                        int nextPosition = array1[row].indexOf(array2[j]);
                        if (nextPosition != position) {
                            flag = false;
                            counter = 0;
                            break;
                        }
                        row++;
                        counter++;
                    }
                }
                if (counter == H2) break;
            }
            if (counter == H2) break;
        }
        return flag;
    }
}
