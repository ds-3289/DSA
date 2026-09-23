class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] jobs=new int[n][3];
        for (int i=0;i<n;i++){
            jobs[i][0]=startTime[i];
            jobs[i][1]=endTime[i];
            jobs[i][2]=profit[i];
        }
        Arrays.sort(jobs,(a,b)->Integer.compare(a[1],b[1]));
        int[] dp=new int[n+1];
        for (int i=1;i<=n;i++){
            int start=jobs[i-1][0];
            int profitNow=jobs[i-1][2];
            int j=binarySearch(jobs,i-1,start);
            dp[i]=Math.max(dp[i-1],dp[j+1]+profitNow);
        }
        return dp[n];
    }

    private int binarySearch(int[][] jobs, int right, int start) {
        int left=0;
        int ans=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(jobs[mid][1]<=start){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}