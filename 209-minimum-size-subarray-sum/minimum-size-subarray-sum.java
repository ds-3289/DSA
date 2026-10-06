class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int l=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int currlen=i-l+1;
            while(sum>=target){
                minlen=Math.min(currlen,minlen);
                sum-=nums[l];
                l++;
                currlen=i-l+1;
            }

        }
        return (minlen==Integer.MAX_VALUE)?0:minlen;
    }
}