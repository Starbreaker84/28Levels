public class Level1 {
    public static String MassVote(int N, int [] Votes) {
        int winVotes = Votes[0];
        int winId = 0;
        for (int i = 1; i < N; i++) {
            if (Votes[i] > winVotes) {
                winVotes = Votes[i];
                winId = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (winVotes == Votes[i] && i != winId) {
                return "no winner";
            }
        }
        double allVotes = 0;
        for (int i = 0; i < N; i++) {
            allVotes += Votes[i];
        }
        double winPercent = (Math.round((winVotes / allVotes) * 100000)) / 1000.0;
        if (winPercent > 50) {
            return "majority winner " + (winId + 1);
        }
        return "minority winner " + (winId + 1);
    }
}
