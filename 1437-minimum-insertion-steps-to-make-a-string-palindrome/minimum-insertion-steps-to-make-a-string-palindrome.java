class Solution {
    public int checkpalin(String s,int ind1,int ind2,int dp[][]){
        if(ind1>ind2){
            return 0;
        }
        if(ind1==ind2){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1)==s.charAt(ind2)){
            return dp[ind1][ind2]=checkpalin(s,ind1+1,ind2-1,dp);
        }
        return dp[ind1][ind2]=Math.min(1+checkpalin(s,ind1+1,ind2,dp),1+checkpalin(s,ind1,ind2-1,dp));
    }
    public int minInsertions(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
        }
        int ans=checkpalin(s,0,n-1,dp);
        return ans;
    }
}