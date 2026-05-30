class Solution {
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int size) {
            n = 1;
            while (n < size) n <<= 1;
            tree = new int[n << 1];
        }

        void update(int pos, int val) {
            int p = pos + n;
            tree[p] = val;
            for (p >>= 1; p > 0; p >>= 1) {
                tree[p] = Math.max(tree[p << 1], tree[p << 1 | 1]);
            }
        }

        int query(int l, int r) {
            int res = 0;
            l += n;
            r += n;

            while (l <= r) {
                if ((l & 1) == 1) res = Math.max(res, tree[l++]);
                if ((r & 1) == 0) res = Math.max(res, tree[r--]);
                l >>= 1;
                r >>= 1;
            }

            return res;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }

        int limit = maxX + 1;

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(limit);

        for (int[] q : queries) {
            if (q[0] == 1) {
                set.add(q[1]);
            }
        }

        SegmentTree seg = new SegmentTree(limit + 1);

        Integer prev = null;
        for (int p : set) {
            if (prev != null) {
                seg.update(p, p - prev);
            }
            prev = p;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 2) {
                int x = q[1];
                int sz = q[2];

                int p = set.floor(x);
                int best = Math.max(seg.query(0, p), x - p);

                ans.add(best >= sz);
            } else {
                int x = q[1];

                int l = set.lower(x);
                int r = set.higher(x);

                seg.update(x, 0);
                seg.update(r, r - l);

                set.remove(x);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}