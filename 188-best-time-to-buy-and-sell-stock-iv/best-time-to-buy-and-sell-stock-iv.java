class Solution {
     public int find(int prices[],int ind,int buy,int count,int n,int dp[][][],int k){
        if(ind==n){
            return 0;
        }
        if(dp[ind][buy][count]!=-1){
            return dp[ind][buy][count];
        }
        int profit=0;
        if(buy==1){
            if(count<k){
           profit=Math.max(-prices[ind]+find(prices,ind+1,0,count+1,n,dp,k),find(prices,ind+1,1,count,n,dp,k));
        }
        }
        else{
                profit=Math.max(prices[ind]+find(prices,ind+1,1,count,n,dp,k),find(prices,ind+1,0,count,n,dp,k));

        }
        return dp[ind][buy][count]=profit;
    }
    public int maxProfit(int k, int[] prices) {
     int n=prices.length;
        int count=0;
        int dp[][][]=new int[n][2][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
            Arrays.fill(dp[i][j],-1);
            }
        }
        int ans=find(prices,0,1,0,n,dp,k);
        return ans;
    }
}