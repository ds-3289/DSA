class Solution {
    public class Triplet implements Comparable<Triplet>{
        int r;
        int c;
        int effort;

        Triplet(int r,int c,int effort){
            this.r=r;
            this.c=c;
            this.effort=effort;
        }

        public int compareTo(Triplet t){
            if(this.effort==t.effort) return this.r-t.r;
            return this.effort-t.effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] ans=new int[heights.length][heights[0].length];
        int m=ans.length;
        int n=ans[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()>0){
            Triplet t=pq.poll();
            int i=t.r;
            int j=t.c;
            int eff=t.effort;
            if(i==m-1 && j==n-1) break;
            if(i>0){
                int e=Math.abs(heights[i][j]-heights[i-1][j]);
                e=Math.max(e,eff);
                if(e<ans[i-1][j]){
                    ans[i-1][j]=e;
                    pq.add(new Triplet(i-1,j,e));
                }
            }
            if(i<m-1){
                int e=Math.abs(heights[i][j]-heights[i+1][j]);
                e=Math.max(e,eff);
                if(e<ans[i+1][j]){
                    ans[i+1][j]=e;
                    pq.add(new Triplet(i+1,j,e));
                }
            }
            if(j<n-1){
                int e=Math.abs(heights[i][j]-heights[i][j+1]);
                e=Math.max(e,eff);
                if(e<ans[i][j+1]){
                    ans[i][j+1]=e;
                    pq.add(new Triplet(i,j+1,e));
                }
            }
            if(j>0){
                int e=Math.abs(heights[i][j]-heights[i][j-1]);
                e=Math.max(e,eff);
                if(e<ans[i][j-1]){
                    ans[i][j-1]=e;
                    pq.add(new Triplet(i,j-1,e));
                }
            }
            
        }
        return ans[m-1][n-1];
    }
}