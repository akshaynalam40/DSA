class pair{
    int node;
    int level;
    public pair(int node,int level){
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public long weightedSum(int[] parent, int[] nums) { 
        int n=parent.length;
        ArrayList<ArrayList<Integer>>adjLs= new ArrayList<>();
        for(int i=0;i<=n-1;i++){
            adjLs.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            adjLs.get(parent[i]).add(i);
        }
        int vis[]= new int[n];
        int maxHeight= dfs(adjLs,0,1);
        long sum=0;
        Queue<pair>que= new LinkedList<>();
        que.offer(new pair(0,1));
        while(!que.isEmpty()){
            int no=que.peek().node;
            int leve=que.peek().level;
            que.remove();
            sum+=(long)nums[no]*(maxHeight-leve+1);
            for(int ele:adjLs.get(no)){
                  que.offer(new pair(ele,leve+1));
            }
        }
        return sum;
    }
    public static int  dfs(ArrayList<ArrayList<Integer>>adjLs,int i,int count){
            int maxi=count;
            for(int node:adjLs.get(i)){
                maxi=Math.max(maxi,
                    dfs(adjLs,node,count+1));
                
            }
            return maxi;
    }

}