class Solution {
    public int findmin(int i, int j,int[][] grid,int[][] dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE / 2;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=grid[i][j]+findmin(i-1,j,grid,dp);
        int left=grid[i][j]+findmin(i,j-1,grid,dp);
        
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=findmin(m-1,n-1,grid,dp);
        return ans;
    }
}