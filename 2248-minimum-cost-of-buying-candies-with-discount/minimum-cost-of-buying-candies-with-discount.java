class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        Arrays.sort(cost);
        int sum=0;
        int i=n-1;
        while(i>=0){
            sum+=cost[i];
            i--;
            if(i>=0){
                sum+=cost[i];
                i--;
            }
            i--;
        }
        return sum;
    }
}