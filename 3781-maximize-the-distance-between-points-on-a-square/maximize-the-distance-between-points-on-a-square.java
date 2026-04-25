class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long L = 4L * side;
        long[] t = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (y == 0) t[i] = x;
            else if (x == side) t[i] = side + y;
            else if (y == side) t[i] = 2L * side + (side - x);
            else t[i] = 3L * side + (side - y);
        }

        Arrays.sort(t);

        long[] t2 = new long[2 * n];
        for (int i = 0; i < n; i++) {
            t2[i] = t[i];
            t2[i + n] = t[i] + L;
        }

        long left = 0, right = L;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (can(t2, n, k, mid, L)) left = mid;
            else right = mid - 1;
        }
        return (int) left;
    }

    private boolean can(long[] t, int n, int k, long d, long L) {
        for (int i = 0; i < n; i++) {
            int count = 1;
            long last = t[i];
            int idx = i;

            while (count < k) {
                int next = lowerBound(t, idx + 1, i + n, last + d);
                if (next == -1) break;
                last = t[next];
                idx = next;
                count++;
            }

            if (count == k && last - t[i] <= L - d) return true;
        }
        return false;
    }

    private int lowerBound(long[] arr, int l, int r, long target) {
        int res = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}