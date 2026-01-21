class Solution {
    public int find(int prices[],int ind,int buy,int n, int fee,int dp[][]){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1){
           profit=Math.max(-prices[ind]-fee+find(prices,ind+1,0,n,fee,dp),find(prices,ind+1,1,n,fee,dp));
        }
        else{
            profit=Math.max(prices[ind]+find(prices,ind+1,1,n,fee,dp),find(prices,ind+1,0,n,fee,dp));
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=find(prices,0,1,n,fee,dp);
        return ans;
    }
}