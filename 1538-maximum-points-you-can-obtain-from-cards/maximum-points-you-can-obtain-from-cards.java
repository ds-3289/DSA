class Solution {
    public int maxScore(int[] arr, int k) {
        int n=arr.length;
        int size=n-k;
        int total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
        }
        int winsum=0;
        for(int i=0;i<size;i++){
            winsum+=arr[i];
        }
        int minsum=winsum;
        for(int i=size;i<n;i++){
            winsum=winsum-arr[i-size]+arr[i];
            minsum=Math.min(minsum,winsum);
        }
        return total-minsum;
    }
}