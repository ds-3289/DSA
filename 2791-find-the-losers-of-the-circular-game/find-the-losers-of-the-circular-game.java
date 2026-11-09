class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] visited = new boolean[n];
        
        int curr = 0;
        int turn = 1;
        
        while (!visited[curr]) {
            visited[curr] = true;
            curr = (curr + turn * k) % n;
            turn++;
        }
        
        int count = 0;
        for (boolean v : visited) {
            if (!v) count++;
        }
        
        int[] ans = new int[count];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans[idx++] = i + 1;
            }
        }
        
        return ans;
    }
}