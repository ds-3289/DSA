class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(sum(nums[i])==i) return i;
        }
        return -1;
    }
    public int sum(int n){
        int rem=0;
        int add=0;
        while(n>0){
            rem=n%10;
            add+=rem;
            n=n/10;
        }
        return add;
    }
}