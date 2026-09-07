class Solution {
    public int arrangeCoins(int n) {
        int val=0;
        for(int i=1;i<=n;i++){
            if(n-i>=0){
                val=i;
                n=n-i;
            }
            
        }
        return val;
    }
}