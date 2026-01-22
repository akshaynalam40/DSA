class Solution {
    public int find(int nums[],int ind,int prev,int n,int dp[][]){
        if(ind==n){
             return 0;
        }
        if(dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        int notpick=find(nums,ind+1,prev,n,dp);
        int pick=0;
        if(prev==-1 || nums[ind]>nums[prev]){
             pick=1+find(nums,ind+1,ind,n,dp);
        }
        return dp[ind][prev+1]=Math.max(notpick,pick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int prev=-1;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=find(nums,0,prev,n,dp);
        return ans;
        
    }
}