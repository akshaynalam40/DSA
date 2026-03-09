class Solution {
    int dp[][][][];
    int MOD=1000000007;
    public int solve(int zero, int one, int limit, int prev, int count) {
        if(count>limit) {
            return 0;
        }
        if(zero==0 &&one==0) {
            return 1;
        }
        if(dp[zero][one][prev][count]!=-1){
            return dp[zero][one][prev][count];
        }
        int ways = 0;
        if(zero>0) {
            if(prev==0) {
                ways+=solve(zero-1,one,limit,0,count+1);
            } 
            else{
                ways+=solve(zero-1,one,limit,0,1);
            }
        }
        if(one>0){
            if(prev==1){
                ways+=solve(zero,one-1,limit,1,count+1);
            } 
            else{
                ways+=solve(zero,one-1,limit,1,1);
            }
        }

        return dp[zero][one][prev][count]=(int)(ways%MOD);
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        long ans = 0;
        dp= new int[zero+1][one+1][2][limit+1];
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                for(int k=0;k<2;k++){
                    for(int l=0;l<=limit;l++){
                        dp[i][j][k][l]=-1;
                    }
                }
            }
        }
        if(zero>0){
            ans+=solve(zero-1,one,limit,0,1);
        }
        if(one>0){
            ans+=solve(zero,one-1,limit,1,1);
        }

        return (int)(ans%MOD);
    }
}