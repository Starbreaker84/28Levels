public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        if (W1 < W2 || H1 < H2) return false;
        String [] array1 = S1.split(" ");
        String [] array2 = S2.split(" ");
        int counter = 0;
        int row;
        for (int i = 0; i < H1; i++) {
            if (H2 > H1 - i) break;
            for (int id = 0; id < W1; id++) {
                int position = array1[i].indexOf(array2[0], id);
                if (position != -1) {
                    id = position;
                    counter++;
                    row = i + 1;
                    for (int j = 1; j < H2; j++) {
                        int nextPosition = array1[row].indexOf(array2[j], id);
                        if (nextPosition != position) {
                            counter = 0;
                            break;
                        }
                        row++;
                        counter++;
                    }
                }
                if (counter == H2) return true;
            }
        }
        return false;
    }
}
