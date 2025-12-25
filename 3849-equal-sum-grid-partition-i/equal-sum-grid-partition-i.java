class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long row[]=new long[m];
        long col[]=new long[n];
        long totalsum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               totalsum+=(long)grid[i][j]; 
            }
            row[i]=totalsum;
        }
        totalsum=0;
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                totalsum+=(long)grid[i][j];
            }
            col[j]=totalsum;
        }
        for(int i=0;i<m;i++){
            if(2*row[i]==totalsum){
                return true;
            }
        }
        for(int j=0;j<n;j++){
            if(2*col[j]==totalsum){
                return true;
            }
        }

       return false;
        
    }
}