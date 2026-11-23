class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = {0, 1, 0, 1};

        for (int i = 1; i < obstacles.length; i++) {
            int obs = obstacles[i];

            if (obs != 0) {
                dp[obs] = Integer.MAX_VALUE;
            }

            for (int lane = 1; lane <= 3; lane++) {
                if (lane != obs) {
                    dp[lane] = Math.min(dp[lane], Math.min(dp[1], Math.min(dp[2], dp[3])) + 1);
                }
            }
        }

        return Math.min(dp[1], Math.min(dp[2], dp[3]));
    }
}