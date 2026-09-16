class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int count=0;
        int prev=0,curr=0,i=0,j=0;
        int total=(m+n);
        while(count<=total/2){
            prev=curr;
            if(i<m && (j>=n || nums1[i]<=nums2[j])) {
                curr=nums1[i++];
            }else{
                curr=nums2[j++];
            }
            count++;
        }
        if(total%2==0){
            return (double)(prev+curr)/2;
        }else return curr;
    }
}