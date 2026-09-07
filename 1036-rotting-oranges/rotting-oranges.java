class Solution {
    public class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int time=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new Pair(i,j));
            }
        }
        while(!q.isEmpty() && fresh>0 ){
            int size=q.size();
        

        while(size-->0){
            Pair top=q.remove();
            int row=top.r;
            int col=top.c;
            if(row>0 && grid[row-1][col]==1){
                q.add(new Pair(row-1,col));
                fresh--;
                grid[row-1][col]=2;
            }
            if(row<n-1 && grid[row+1][col]==1){
                q.add(new Pair(row+1,col));
                fresh--;
                grid[row+1][col]=2;
            }
            if(col>0 && grid[row][col-1]==1){
                q.add(new Pair(row,col-1));
                fresh--;
                grid[row][col-1]=2;
            }
            if(col<m-1 && grid[row][col+1]==1){
                q.add(new Pair(row,col+1));
                fresh--;
                grid[row][col+1]=2;
            }
        }
            time++;
           
        }
        
        if(fresh>0) return -1;
        return time;
        
    }
}