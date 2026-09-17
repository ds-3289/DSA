class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && dp[left - 1] > 0) {
                    ans = Math.min(ans, dp[left - 1] + len);
                }

                if (right == 0) {
                    dp[right] = len;
                } else {
                    dp[right] = Math.min(dp[right - 1] == 0 ? Integer.MAX_VALUE : dp[right - 1], len);
                }
            } else {
                dp[right] = right == 0 ? 0 : dp[right - 1];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}