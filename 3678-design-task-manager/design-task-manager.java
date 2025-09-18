class Pair {
    int userId;
    int priority;
    Pair(int u,int p){
        this.userId=u;
        this.priority=p;
    }
}
class TaskManager {
    HashMap<Integer,Pair>map= new HashMap<>();
    PriorityQueue<int[]>pq;
    public TaskManager(List<List<Integer>> tasks) {
        pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return  b[1]-a[1];
            }
            return b[0]-a[0];
        });
         for(List<Integer>temp:tasks){
            int userId=temp.get(0);
            int taskId=temp.get(1);
            int priority=temp.get(2);
            map.put(taskId,new Pair(userId,priority));
            pq.add(new int[]{priority,taskId,userId});
         }
    }
    public void add(int userId, int taskId, int priority) {
        map.put(taskId,new Pair(userId,priority));
        pq.add(new int[]{priority,taskId,userId});
    }
    
    public void edit(int taskId, int newPriority) {
        if(!map.containsKey(taskId)){
            return;
        }
        Pair p=map.get(taskId);
        p.priority=newPriority;
        pq.add(new int[]{newPriority,taskId,p.userId});
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            int[] top= pq.poll();
            int priority=top[0],taskId=top[1],userId=top[2];
            if(map.containsKey(taskId)){
                Pair p=map.get(taskId);
                if(p.priority==priority && p.userId== userId){
                    map.remove(taskId);
                    return userId;
                }
            }
        }
        return -1;
        
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */