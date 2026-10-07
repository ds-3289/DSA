class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int currMax=0;
        int maxSum=Integer.MIN_VALUE;
        int currMin=0;
        int minSum=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            currMax=Math.max(nums[i],currMax+nums[i]);
            maxSum=Math.max(maxSum,currMax);

            currMin=Math.min(nums[i],currMin+nums[i]);
            minSum=Math.min(minSum,currMin);
        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,total-minSum);
    }
}