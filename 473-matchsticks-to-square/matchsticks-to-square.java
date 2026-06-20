class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        long sum = 0;

        for (int x : matchsticks) sum += x;

        if (sum % 4 != 0) return false;

        int target = (int) (sum / 4);

        Arrays.sort(matchsticks);

        int[] sides = new int[4];

        return dfs(matchsticks, n - 1, sides, target);
    }

    private boolean dfs(int[] matchsticks, int idx, int[] sides, int target) {
        if (idx < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = matchsticks[idx];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target) continue;

            sides[i] += stick;

            if (dfs(matchsticks, idx - 1, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            if (sides[i] == 0) break;
        }

        return false;
    }
}