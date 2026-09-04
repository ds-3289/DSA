class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int diff;

        Triplet(int row, int col, int diff){
            this.row=row;
            this.col=col;
            this.diff=diff;
        }
        public int compareTo(Triplet t){
            return this.diff-t.diff;
        }

    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(pq.size()>0){
            Triplet top=pq.remove();
            int r=top.row,c=top.col,d=top.diff;
            if(r==m-1 && c==n-1) break;
            if(r>0){
                int e=Math.abs(heights[r][c]-heights[r-1][c]);
                e=Math.max(e,d);
                if(e<ans[r-1][c]){
                    ans[r-1][c]=e;
                    pq.add(new Triplet(r-1,c,e));
                }
            }
            if(c>0){
                int e=Math.abs(heights[r][c]-heights[r][c-1]);
                e=Math.max(e,d);
                if(e<ans[r][c-1]){
                    ans[r][c-1]=e;
                    pq.add(new Triplet(r,c-1,e));
                }
            }
            if(r<m-1){
                int e=Math.abs(heights[r][c]-heights[r+1][c]);
                e=Math.max(e,d);
                if(e<ans[r+1][c]){
                    ans[r+1][c]=e;
                    pq.add(new Triplet(r+1,c,e));
                }
            }
            if(c<n-1){
                int e=Math.abs(heights[r][c]-heights[r][c+1]);
                e=Math.max(e,d);
                if(e<ans[r][c+1]){
                    ans[r][c+1]=e;
                    pq.add(new Triplet(r,c+1,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}