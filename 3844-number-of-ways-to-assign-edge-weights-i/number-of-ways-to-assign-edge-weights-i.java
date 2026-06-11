class Solution {
    static final long MOD = 1000000007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        java.util.List<Integer>[] graph = new java.util.ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] vis = new boolean[n + 1];
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{1, 0});
        vis[1] = true;

        int maxDepth = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int nei : graph[node]) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.offer(new int[]{nei, depth + 1});
                }
            }
        }

        long ans = modPow(2, maxDepth - 1);
        return (int) ans;
    }

    private long modPow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}