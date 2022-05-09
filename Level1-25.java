import java.util.*;

public class Level1 {
    private static int[] transform(int[] A, int N){
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                int k = i + j;
                B.add(getMax(j, k, A));
            }
        }
        return B.stream().mapToInt(i -> i).toArray();
    }
    private static int getKey(int [] array){
        int sum = 0;
        for (int i : array) sum += i;
        return sum;
    }
    private static int getMax(int j, int k, int[] A) {
        int max = A[j];
        for (int i = j; i <= k; i++) {
            if (A[i] > max) max = A[i];
        }
        return max;
    }
    public static boolean TransformTransform(int A[], int N){
        int[] S = transform(A, N);
        S = transform(S, S.length);
        int key = getKey(S);
        return key % 2 == 0;
    }
}
