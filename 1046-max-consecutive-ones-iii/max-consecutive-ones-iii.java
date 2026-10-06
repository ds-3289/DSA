class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int maxFreq=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                maxFreq++;
            }
            while(i-l+1-maxFreq>k){
                if(nums[l]==1) maxFreq--;
                l++;
            }
            maxLen=Math.max(maxLen,i-l+1);
        }
        return maxLen;
    }
}