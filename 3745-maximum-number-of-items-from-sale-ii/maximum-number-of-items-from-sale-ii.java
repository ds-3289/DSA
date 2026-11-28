class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        int[] free = new int[maxFactor + 1];

        for (int i = 1; i <= maxFactor; i++) {
            for (int j = i; j <= maxFactor; j += i) {
                free[i] += freq[j];
            }
            free[i]--;
        }

        java.util.Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long ans = 0;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price > 2L * minPrice) {
                break;
            }

            int take = Math.min(budget / price, free[factor]);

            ans += 2L * take;
            budget -= take * price;
        }

        ans += budget / minPrice;

        return (int) ans;
    }
}