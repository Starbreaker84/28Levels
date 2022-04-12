public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary){
        if (N == 1) return salary;
        int [] orderedIds = new int[N];
        int [] orderedSalary = new int[N];
        for (int i = 0; i < N; i++) {
            orderedIds[i] = ids[i];
            orderedSalary[i] = salary[i];
        }
        int item;
        boolean xchange = true;
        while (xchange) {
            xchange = false;
            for (int i = 0; i < N - 1; i++) {
                if (orderedIds[i] > orderedIds[i + 1]) {
                    item = orderedIds[i];
                    orderedIds[i] = orderedIds[i + 1];
                    orderedIds[i + 1] = item;
                    xchange = true;
                }
            }
        }
        xchange = true;
        while (xchange) {
            xchange = false;
            for (int i = 0; i < N - 1; i++) {
                if (orderedSalary[i] > orderedSalary[i + 1]) {
                    item = orderedSalary[i];
                    orderedSalary[i] = orderedSalary[i + 1];
                    orderedSalary[i + 1] = item;
                    xchange = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (ids[i] == orderedIds[j]) {
                    salary[i] = orderedSalary[j];
                }
            }
        }
        return salary;
    }
}
