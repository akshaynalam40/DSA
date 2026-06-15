class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adjLs=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjLs.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adjLs.get(u).add(v);
        }
        int indegree[]= new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adjLs.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer>queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        ArrayList<Integer>topo=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.peek();
            queue.remove();
            topo.add(node);
            for(int it:adjLs.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }

        }
        if(topo.size()==numCourses){
            return true;
        }
        return false;
    }
}