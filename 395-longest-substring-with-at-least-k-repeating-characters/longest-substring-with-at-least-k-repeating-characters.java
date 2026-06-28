class Solution {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int left, int right, int k) {
        if (right - left < k) return 0;

        int[] freq = new int[26];
        for (int i = left; i < right; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = left; i < right; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < right && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }
                return Math.max(solve(s, left, i, k), solve(s, j, right, k));
            }
        }

        return right - left;
    }
}