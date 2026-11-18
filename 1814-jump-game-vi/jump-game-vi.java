class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] deque = new int[n];
        int head = 0;
        int tail = 0;

        dp[0] = nums[0];
        deque[tail++] = 0;

        for (int i = 1; i < n; i++) {
            while (head < tail && deque[head] < i - k) {
                head++;
            }

            dp[i] = dp[deque[head]] + nums[i];

            while (head < tail && dp[deque[tail - 1]] <= dp[i]) {
                tail--;
            }

            deque[tail++] = i;
        }

        return dp[n - 1];
    }
}