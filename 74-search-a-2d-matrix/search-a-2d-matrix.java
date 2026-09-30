class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int n=r*c;
        int l=0;
        int h=n-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int mide=matrix[mid/c][mid%c];
            if(target==mide) return true;
            else if(target<mide){
                h=mid-1;
            }else if(target>mide){
                l=mid+1;
            }
        }
        return false;
    }
}