class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow=0;
        int pos=0;
        for(int[] arr:points){
            if(arrow==0 || arr[0]>pos){
                arrow++;
                pos=arr[1];
            }
        }
        return arrow;
    }
}  