class Solution {
    public int find(String s,int ind,int k,int n,char ch,int dp[][]){
        if(ind==n){
            return 0;
        }
        if(dp[ind][ch]!=-1){
            return dp[ind][ch];
        }
        int pick=0;
        int notpick=0;
        if (Math.abs(ch - s.charAt(ind))<= k ||ch == '#'){
                pick=1+find(s,ind+1,k,n,s.charAt(ind),dp);
        }
        notpick=find(s,ind+1,k,n,ch,dp);
        return dp[ind][ch]=Math.max(pick,notpick);
    }
    public int longestIdealString(String s, int k) {
        int n=s.length();
        int dp[][]=new int[n][130];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=find(s,0,k,n,'#',dp);
        return ans;
    }
}