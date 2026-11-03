class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        int sum=0;
        for(int num:nums){
            sum+=Math.abs(num-max);
        }
        return sum;
    }
}