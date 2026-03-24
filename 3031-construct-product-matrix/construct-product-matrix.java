class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res[][]= new int[n][m];
        long pre[]= new long[m*n];
        long suff[]= new long[m*n];
        int size=m*n;
        pre[0]=1;
         for(int i=1;i<size;i++){
            int r=(i-1)/m;
            int c=(i-1)%m;
            pre[i]=(pre[i-1]*grid[r][c])%12345;
         }
         suff[size-1]=1;
         for(int i=size-2;i>=0;i--){
            int r=(i+1)/m;
            int c=(i+1)%m;
            suff[i]=(suff[i+1]*grid[r][c])%12345;
         }
         for(int i=0;i<size;i++){
            int r=i/m;
            int c=i%m;
            res[r][c]=(int)((pre[i]*suff[i])%12345);
         }

        return res;
    }
}