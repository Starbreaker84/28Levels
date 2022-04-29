public class Level1 {
    private static void nStep(boolean [] doors, int index){
        for (int i = 1; i <= doors.length; i++){
            if (i % index == 0) doors[i - 1] = !doors[i - 1];
        }
    }
    public static String Keymaker(int k) {
        boolean[] doors = new boolean[k];
        for (int i = 1; i <= k; i++) {
            nStep(doors, i);
        }
        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (doors[i]) bld.append("1");
            if (!doors[i]) bld.append("0");
        }
        return bld.toString();
    }
}
