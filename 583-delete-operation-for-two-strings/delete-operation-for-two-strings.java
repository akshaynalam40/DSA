class Solution {
    public int calmin(String word1,String word2,int ind1,int ind2,int dp[][]){
        if(ind1<0 && ind2<0){
            return 0;
        }
        if(ind1<0){
            return ind2+1;
        }
        if(ind2<0){
            return ind1+1;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(word1.charAt(ind1)==word2.charAt(ind2)){
            return dp[ind1][ind2]=calmin(word1,word2,ind1-1,ind2-1,dp);
        }
        return dp[ind1][ind2]=1+Math.min(calmin(word1,word2,ind1-1,ind2,dp),calmin(word1,word2,ind1,ind2-1,dp));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=calmin(word1,word2,n-1,m-1,dp);
        return ans;
    }
}