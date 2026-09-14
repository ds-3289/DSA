class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n = position.length;
        double[] mergeTime = new double[n];
        Arrays.fill(mergeTime, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty()) {
                int j = st.peek();
                double t;
                long gap = (long) position[j] - position[i];
                if (gap <= distance) {
                    t = 0.0;
                } else {
                    long relSpeed = (long) speed[i] - speed[j];
                    if (relSpeed <= 0) {
                        t = Double.POSITIVE_INFINITY;
                    } else {
                        t = (double) (gap - distance) / relSpeed;
                    }
                }
                if (t == Double.POSITIVE_INFINITY) {
                    st.pop();
                } else if (mergeTime[j] < 0 || t <= mergeTime[j]) {
                    mergeTime[i] = t;
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(i);
        }
        int groups = 0;
        for (double t : mergeTime) {
            if (t < 0) groups++;
        }
        return groups;
    }
}