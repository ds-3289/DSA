class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long[] xs = {
            0L,
            Math.min(need1, need2),
            Math.max(need1, need2)
        };

        long ans = Long.MAX_VALUE;

        for (long x : xs) {
            long cost = x * costBoth
                    + Math.max(0L, (long) need1 - x) * cost1
                    + Math.max(0L, (long) need2 - x) * cost2;

            ans = Math.min(ans, cost);
        }

        return ans;
    }
}