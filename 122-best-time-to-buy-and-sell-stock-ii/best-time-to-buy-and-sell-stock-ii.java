class Solution {
    public int findbest(int prices[],int ind,int buy,int n,int dp[][]){
        if(ind==n){
            return 0;
        }
        int profit=0;
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        if(buy==1){
            profit=Math.max(-prices[ind]+findbest(prices,ind+1,0,n,dp),findbest(prices,ind+1,1,n,dp));
        }
        else{
            profit=Math.max(prices[ind]+findbest(prices,ind+1,1,n,dp),findbest(prices,ind+1,0,n,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int profit=0;
         int ans=findbest(prices,0,1,n,dp);
         return ans;
        
    }
}