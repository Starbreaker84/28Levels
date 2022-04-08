package exercises;

public class Level2 {
    public static int odometer(int [] oksana){
        int pastHours = 0;
        int distance = 0;
        for (int i = 0; i < oksana.length; i++) {
            if (i % 2 != 0) {
                distance += oksana[i - 1] * (oksana[i] - pastHours);
                pastHours = oksana[i];
            }
        }
        return distance;
    }
}
