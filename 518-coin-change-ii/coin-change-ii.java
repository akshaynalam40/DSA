class Solution {
    public int  findways(int target,int[] nums,int ind,int dp[][]){
        if(ind==0){
            if(target%nums[ind]==0){
                return 1;
            }
            return 0;
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int notpick=findways(target,nums,ind-1,dp);
        int pick=0;
        if(nums[ind]<=target){
            pick=findways(target-nums[ind],nums,ind,dp);
        }
        return dp[ind][target]= pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
          Arrays.fill(dp[i],-1);
        }
        int ans=findways(amount,coins,n-1,dp);
        return ans;
    }
}