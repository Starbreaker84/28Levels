public class Level1 {
    private static int [] sorter (int N, int [] price) {
        int number;
        boolean xchange = true;
        while (xchange) {
            xchange = false;
            for (int i = 0; i < N - 1; i++) {
                if (price[i] < price[i + 1]) {
                    number = price[i];
                    price[i] = price[i+1];
                    price[i+1] = number;
                    xchange = true;
                }
            }
        }
        return price;
    }

    public static int MaximumDiscount(int N, int [] price) {
        int [] sortedPrice = sorter(N, price);
        int discount = 0;
        for (int i = 0; i < N; i++) {
            if ((i + 1) % 3 == 0){
                discount += sortedPrice[i];
            }
        }
        return discount;
    }
}
