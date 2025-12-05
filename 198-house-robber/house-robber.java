class Solution {
    public int find(int ind,int arr[],int dp[]){
        if(ind==0){
            return arr[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick=arr[ind]+find(ind-2,arr,dp);
        int notpick=find(ind-1,arr,dp);

        return dp[ind]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]= new int[n];
        Arrays.fill(dp,-1);
        return find(n-1,nums,dp);
        
    }
}