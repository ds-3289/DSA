class Solution {
    private Boolean[] memo;
    private int n;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;

        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;

        n = maxChoosableInteger;
        memo = new Boolean[1 << n];

        return dfs(0, desiredTotal);
    }

    private boolean dfs(int mask, int remain) {
        if (memo[mask] != null) return memo[mask];

        for (int i = 1; i <= n; i++) {
            int bit = 1 << (i - 1);

            if ((mask & bit) == 0) {
                if (i >= remain || !dfs(mask | bit, remain - i)) {
                    return memo[mask] = true;
                }
            }
        }

        return memo[mask] = false;
    }
}