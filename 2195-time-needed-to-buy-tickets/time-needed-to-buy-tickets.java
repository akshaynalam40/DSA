class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.add(tickets[i]);
        }
        int val=0;
        int sum=0;
        while(true){
            if(!q.isEmpty()){
            val=q.poll();
            }
            time+=1;
            if(k==0 && val-1 == 0){
                break;
            }
            if(val-1>0){
                q.add(val-1);
            }
            k=(k-1)%q.size();
            if(k<0) k+=q.size();
         
        }
        return time;
    }
}