class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean[] visitedBus = new boolean[routes.length];
        Set<Integer> visitedStop = new HashSet<>();
        int buses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            buses++;
            for (int i = 0; i < size; i++) {
                int stop = q.poll();
                for (int bus : map.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBus[bus]) continue;
                    visitedBus[bus] = true;
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        if (visitedStop.add(nextStop)) {
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}