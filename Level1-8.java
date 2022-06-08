public class Task8 {
    private static int adder(int i, int [] data) {
        int sum = 0;
        for (int j = 0; j < data.length; j++){
            if (j != i) sum += data[j];
        }
        return sum;
    }

    public static int SumOfThe(int N, int [] data) {
        int sumOfAllOtherNumbers = 0;
        for (int i = 0; i < N; i++) {
            sumOfAllOtherNumbers = adder(i, data);
            if (sumOfAllOtherNumbers == data[i]) break;
        }
        return sumOfAllOtherNumbers;
    }
}
