class Solution {
    public int profit(int i,int[] nums,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int skip=profit(i+1,nums,dp);
        int steal=nums[i]+profit(i+2,nums,dp);
        dp[i]=Math.max(skip,steal);
        return dp[i];
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return profit(0,nums,dp);
    }
}