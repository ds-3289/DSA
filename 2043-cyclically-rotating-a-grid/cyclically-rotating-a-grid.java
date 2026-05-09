class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int top = layer, left = layer;
            int bottom = m - layer - 1, right = n - layer - 1;

            java.util.List<Integer> list = new java.util.ArrayList<>();

            for (int j = left; j <= right; j++) list.add(grid[top][j]);
            for (int i = top + 1; i <= bottom; i++) list.add(grid[i][right]);
            for (int j = right - 1; j >= left; j--) list.add(grid[bottom][j]);
            for (int i = bottom - 1; i > top; i--) list.add(grid[i][left]);

            int len = list.size();
            int rot = k % len;

            java.util.List<Integer> rotated = new java.util.ArrayList<>();

            for (int i = rot; i < len; i++) rotated.add(list.get(i));
            for (int i = 0; i < rot; i++) rotated.add(list.get(i));

            int idx = 0;

            for (int j = left; j <= right; j++) grid[top][j] = rotated.get(idx++);
            for (int i = top + 1; i <= bottom; i++) grid[i][right] = rotated.get(idx++);
            for (int j = right - 1; j >= left; j--) grid[bottom][j] = rotated.get(idx++);
            for (int i = bottom - 1; i > top; i--) grid[i][left] = rotated.get(idx++);
        }

        return grid;
    }
}