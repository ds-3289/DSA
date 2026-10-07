class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int newmax=Math.max(curr,Math.max(curr*max,curr*min));
            int newmin=Math.min(curr,Math.min(curr*max,curr*min));
            max=newmax;
            min=newmin;
            ans=Math.max(ans,max);
        }
        return ans;
    }
}