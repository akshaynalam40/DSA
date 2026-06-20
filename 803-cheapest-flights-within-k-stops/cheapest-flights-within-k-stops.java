class tuple{
    int dis;
    int node;
    int count;
    public tuple(int dis,int node,int count){
        this.dis=dis;
        this.node=node;
        this.count=count;
    }
}
class pair{
        int node;
        int weight;
        public pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>>adjLs= new ArrayList<>();
        int rows=flights.length;
        int cols=flights[0].length;
        for(int i=0;i<n;i++){
            adjLs.add(new ArrayList<>());
        }
        int dis[][]= new int[n][k+2];
        for(int i=0;i<rows;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adjLs.get(u).add(new pair(v,w));
        }
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        PriorityQueue<tuple>pq= new PriorityQueue<>(
            (a,b)->a.dis-b.dis
        );
        pq.offer(new tuple(0,src,0));
        dis[src][0]=0;
        while(!pq.isEmpty()){
            tuple val=pq.poll();
            int distance=val.dis;
            int nod=val.node;
            int cnt=val.count;
            if(nod==dst){
                return distance;
            }
            if(cnt>k+1){
                continue;
            }
            for(pair it:adjLs.get(nod)){
                  pair value=it;
                  int no=value.node;
                  int wei=value.weight;
                  if(cnt+1<=k+1 && dis[no][cnt+1]>wei+distance){
                    dis[no][cnt+1]=wei+distance;
                    pq.offer(new tuple(wei+distance,no,cnt+1));
                  }  

            }

        }


return -1;
        
    }
}