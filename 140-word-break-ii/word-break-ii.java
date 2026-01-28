class Solution {
    Map<Integer, List<String>> memo = new HashMap<>();
    Set<String> set;

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private List<String> dfs(String s, int index) {
        if (memo.containsKey(index)) return memo.get(index);

        List<String> res = new ArrayList<>();
        if (index == s.length()) {
            res.add("");
            return res;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (set.contains(word)) {
                List<String> next = dfs(s, i);
                for (String str : next) {
                    res.add(str.isEmpty() ? word : word + " " + str);
                }
            }
        }

        memo.put(index, res);
        return res;
    }
}
