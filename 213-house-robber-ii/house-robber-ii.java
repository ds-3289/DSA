class Solution {
    public int profit0(int[] nums,int i,int[] dp1){
        if(i>=nums.length-1)return 0;
        if(dp1[i]!=-1) return dp1[i];
        int steal=nums[i]+profit0(nums,i+2,dp1);
        int skip=profit0(nums,i+1,dp1);
        return dp1[i]=Math.max(steal,skip);
    }
    public int profit1(int[] nums,int i,int[] dp2){
        if(i>=nums.length)return 0;
        if(dp2[i]!=-1) return dp2[i];
        int steal=nums[i]+profit1(nums,i+2,dp2);
        int skip=profit1(nums,i+1,dp2);
        return dp2[i]=Math.max(steal,skip);
    }

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(profit0(nums,0,dp1),profit1(nums,1,dp2));
    }
}