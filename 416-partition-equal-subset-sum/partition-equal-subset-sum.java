class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if(total % 2 != 0) return false;
        int target=total/2;
        boolean[] dp=new boolean[target+1];
        dp[0]=true;
        for(int i:nums){
            for(int j=target;j>=i;j--){
                dp[j]=dp[j] || dp[j-i];
            }
        }
        
        return dp[target];
    }
}