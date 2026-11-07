class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                    ? ((int) a[2] == (int) b[2]
                       ? (int) a[1] - (int) b[1]
                       : (int) a[2] - (int) b[2])
                    : Long.compare(a[0], b[0])
        );

        int n = servers.length;

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int m = tasks.length;
        int[] ans = new int[m];

        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[2], (int) s[1]});
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();
                    free.offer(new int[]{(int) s[2], (int) s[1]});
                }
            }

            int[] server = free.poll();

            ans[i] = server[1];

            busy.offer(new long[]{
                time + tasks[i],
                server[1],
                server[0]
            });
        }

        return ans;
    }
}