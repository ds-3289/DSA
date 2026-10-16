class Solution {
    public class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int cost;

        Triplet(int node,int parent,int cost){
            this.node=node;
            this.parent=parent;
            this.cost=cost;
        }

        public int compareTo(Triplet t){
            if(this.cost==t.cost) return this.node-t.node;
            return this.cost-t.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        boolean [] vis=new boolean[points.length];
        int sum=0;
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        pq.add(new Triplet(0,-1,0));
        while(pq.size()>0){
            Triplet Top=pq.remove();
            int node=Top.node;
            int parent=Top.parent;
            int dist=Top.cost;
            if(vis[node]==true) continue;
            sum+=dist;
            vis[node]=true;
            for(int i=0;i<points.length;i++){
                if(i==node || i==parent) continue;
                if(vis[i]==true) continue;
                int x1=points[node][0] , y1=points[node][1];
                int x2=points[i][0] , y2=points[i][1];
                int mtd=Math.abs(x2-x1)+Math.abs(y2-y1);
                pq.add(new Triplet(i,node,mtd));
            }
        }
        return sum;

    }
}