class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        Map<Integer,Set<Integer>> dp=new HashMap<>();
        for (int stone:stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(0).add(0);
        for (int i=0;i<n;i++) {
            int stone = stones[i];

            for (int jump:dp.get(stone)) {
                for (int nextJump=jump-1; nextJump<=jump+1; nextJump++) {
                    if (nextJump<=0) continue;

                    int nextStone=stone+nextJump;

                    if (nextStone==stones[n-1]) {
                        return true;
                    }
                    if (dp.containsKey(nextStone)) {
                        dp.get(nextStone).add(nextJump);
                    }
                }
            }
        }   
        return false;
    }
}