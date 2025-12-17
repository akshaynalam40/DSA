class Solution {
    public int calculateMinSum(List<List<Integer>> triangle, int row, int col, int n,int dp[][]) {
        if (row==n-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=Integer.MAX_VALUE){
            return dp[row][col];
        }
        int l=calculateMinSum(triangle, row + 1, col, n,dp);
        int r=calculateMinSum(triangle, row + 1, col + 1, n,dp);
        int remain = Math.min(l, r);
        return dp[row][col]=triangle.get(row).get(col) + remain;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return calculateMinSum(triangle, 0, 0, n,dp);
    }
}
