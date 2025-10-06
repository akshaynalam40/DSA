class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int low=0;
        int high=n*n-1;
        while(low<=high){
            int mid=(low+high)/2;
            boolean vis[][]=new boolean[n][m];
            if(isPossible(grid,mid,0,0,vis,n,m)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
    public boolean isPossible(int[][] grid,int val, int row, int col, boolean[][] vis,int n, int m){
        if(row<0||row>=n||col<0||col>=m||grid[row][col]>val||vis[row][col]){
            return false;
        }
        if(row==n-1 && col==m-1){
            return true;
        }
        vis[row][col]=true;
        boolean top=isPossible(grid,val,row-1,col,vis,n,m);
        boolean down=isPossible(grid,val,row+1,col,vis,n,m);
        boolean left=isPossible(grid,val,row,col-1,vis,n,m);
        boolean right=isPossible(grid,val,row,col+1,vis,n,m);
        
        return top||down||left||right;
    }
}