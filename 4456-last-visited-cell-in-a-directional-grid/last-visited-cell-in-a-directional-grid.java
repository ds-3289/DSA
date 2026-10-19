class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int[] arr=new int[2];
        path(0,0,grid,arr);
        return arr;
    }
    public void path(int i,int j,char[][] grid,int[] arr){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0|| i>=m || j<0 || j>=n || grid[i][j]=='T') return;
        arr[0]=i;
        arr[1]=j;
        if(grid[i][j]=='R' && j+1<n){
            grid[i][j]='T';
            path(i,j+1,grid,arr);
        }
        if(grid[i][j]=='L' && j>=0){
            grid[i][j]='T';
            path(i,j-1,grid,arr);
        }
        if(grid[i][j]=='D' && i+1<m){
            grid[i][j]='T';
            path(i+1,j,grid,arr);
        }
        if(grid[i][j]=='U' && i>=0){
            grid[i][j]='T';
            path(i-1,j,grid,arr);
        }
        return;     
    }
}