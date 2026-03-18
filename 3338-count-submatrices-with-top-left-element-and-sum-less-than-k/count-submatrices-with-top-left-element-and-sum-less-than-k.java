class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int pre[][]=new int[m][n];
        pre[0][0]=grid[0][0];
        if(pre[0][0]<=k){
            count++;
        }
        for(int i=1;i<m;i++){
            pre[i][0]=pre[i-1][0]+grid[i][0];
            if(pre[i][0]<=k){
                count++;
            }
        }
        for(int j=1;j<n;j++){
            pre[0][j]=pre[0][j-1]+grid[0][j];
            if(pre[0][j]<=k){
                count++;
            }
        }
        for(int i=1;i<m;i++){
          for(int j=1;j<n;j++){
            int val=pre[i-1][j]+pre[i][j-1];
            val+=grid[i][j]-pre[i-1][j-1];
            pre[i][j]=val;
            if(val<=k){
                count++;
            }

          }
        }
        return count;
        
    }
}