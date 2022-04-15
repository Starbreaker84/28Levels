public class Level1 {
    private  static int adder(int i, int [] data) {
        int sum = 0;
        for (int j = 0; j < data.length; j++){
            if (j != i) sum += data[j];
        }
        return sum;
    }

    public static int SumOfThe(int N, int [] data) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = adder(i, data);
            if (result == data[i]) break;
        }
        return result;
    }
}
