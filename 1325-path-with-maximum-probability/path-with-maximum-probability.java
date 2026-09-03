class Solution {
    public class Pair{
        int node;
        double time;
        Pair(int node , double time){
            this.node=node;
            this.time=time;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
            for(int i=0;i<edges.length;i++){
                int u=edges[i][0],v=edges[i][1];
                double time=succProb[i];
                adj.get(u).add(new Pair(v, succProb[i]));
                adj.get(v).add(new Pair(u, succProb[i]));
        }
        double[]ans=new double[n];
        Arrays.fill(ans,0);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.time,a.time));
        ans[start]=1;
        pq.add(new Pair(start,1));
        while(pq.size()>0){
            Pair top=pq.remove();
            int node=top.node;
            double t=top.time;
            for(Pair p:adj.get(node)){
                double totalTime=t*p.time;
                if(ans[p.node]<totalTime){
                    ans[p.node]=totalTime;
                    pq.add(new Pair(p.node,totalTime));
                }

            }
        }
        return ans[end];
    }
}