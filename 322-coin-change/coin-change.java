class Solution {
    public int cal(int ind,int[] coins,int target,int[][] dp){
         if(ind==0){
            if(target%coins[0]==0){
                return target/coins[0];
            }
            else{
                return (int)(1e9);
            }
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int notpick=cal(ind-1,coins,target,dp);
        int pick=(int)(1e9);
        if(coins[ind]<=target){
            pick=1+cal(ind,coins,target-coins[ind],dp);
        }
        return dp[ind][target]=Math.min(pick,notpick);
        
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]= new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=cal(n-1,coins,amount,dp);
        if(ans>=(int)(1e9)){
            return -1;
        }
        return ans;
    }
}