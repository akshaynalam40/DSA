class Solution {
    public int Lcs(String s,String rev,int ind1,int ind2,int dp[][]){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1)==rev.charAt(ind2)){
           return dp[ind1][ind2]= 1+Lcs(s,rev,ind1-1,ind2-1,dp);
        }
        return dp[ind1][ind2]=Math.max(Lcs(s,rev,ind1-1,ind2,dp),Lcs(s,rev,ind1,ind2-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        StringBuilder l=new StringBuilder(s);
        String rev=l.reverse().toString();
        int ans=Lcs(s,rev,n-1,n-1,dp);
        return ans;
    }
}