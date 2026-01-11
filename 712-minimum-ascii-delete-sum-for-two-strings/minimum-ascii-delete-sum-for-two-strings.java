class Solution {
    public int solve(int ind1,int ind2,String s,String t,int dp[][]){
        if(ind1<0 && ind2<0){
            return 0;
        }
        if(ind1<0) {
            int sum = 0;
            for(int i = 0; i <= ind2; i++) {
                sum += t.charAt(i);
            }
            return sum;
        }
         if(ind2<0) {
            int sum = 0;
            for(int i = 0;i<= ind1;i++) {
                sum += s.charAt(i);
            }
            return sum;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1)==t.charAt(ind2)){
            return dp[ind1][ind2]=solve(ind1-1,ind2-1,s,t,dp);
        }
        return dp[ind1][ind2]=Math.min((int)t.charAt(ind2)+solve(ind1,ind2-1,s,t,dp),(int)(s.charAt(ind1))+solve(ind1-1,ind2,s,t,dp));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=solve(n-1,m-1,s1,s2,dp);  
        return ans;
    }
}