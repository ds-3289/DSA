class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, maxFreq = 0, ans = 0;

        for (int right = 0; right < nums.size(); right++) {
            int x = nums.get(right);
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(x));

            while (right - left + 1 - maxFreq > k) {
                int y = nums.get(left++);
                freq.put(y, freq.get(y) - 1);
            }

            ans = Math.max(ans, maxFreq);
        }

        return ans;
    }
}