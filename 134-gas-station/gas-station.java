class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
        }
        if(sum<0){
            return -1;
        }
        int take=0;
        int ans=0;
        for(int i=0;i<n;i++){
            take+=gas[i]-cost[i];
            if(take<0){
              ans=i+1;
              take=0;
            }
        }
        

        return ans;
    }
}