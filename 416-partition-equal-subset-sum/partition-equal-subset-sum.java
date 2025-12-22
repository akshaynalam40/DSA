class Solution {
    public boolean solve(int ind,int target,int[] nums,int dp[][]){
        if(target==0){
            return true;
        }
        if(ind==0){
            if(nums[0]==target){
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target]==1;
        }
        boolean notpick=solve(ind-1,target,nums,dp);
        boolean pick=false;
        if(nums[ind]<=target){
           pick=solve(ind-1,target-nums[ind],nums,dp);
        }
        dp[ind][target]=(notpick||pick) ? 1 : 0;
        return pick||notpick;

    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int[][] dp = new int[n][sum/2+ 1];
        for(int i=0;i<n;i++){
           Arrays.fill(dp[i], -1);
        } 
        boolean ans=solve(n-1,sum/2,nums,dp);
        return ans;
    }
}