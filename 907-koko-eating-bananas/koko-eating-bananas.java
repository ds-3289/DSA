class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int high=piles[piles.length-1];
        int low=1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(canEat(piles,h,mid)) high=mid;
            else low=mid+1;
        }
        return low;
    }
    
    public boolean canEat(int[] piles, int h, int k) {
        int hours=0;
        for(int pile:piles){
            hours+=(pile+k-1)/k;
        }
        if(hours<=h) return true;
        return false;
    }
}