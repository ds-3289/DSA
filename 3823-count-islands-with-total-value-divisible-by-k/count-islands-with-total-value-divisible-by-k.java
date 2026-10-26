class Solution {
    public long dfs(int[][] arr,int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==0) return 0;
        
        long sum=arr[i][j];
        arr[i][j]=0;
        if(i>0) sum+=dfs(arr,i-1,j);
        if(i+1<arr.length) sum+=dfs(arr,i+1,j);
        if(j>0) sum+=dfs(arr,i,j-1);
        if(j+1<arr[0].length) sum+=dfs(arr,i,j+1);
        
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    long sum=0;
                    sum+=dfs(grid,i,j);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
}