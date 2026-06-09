class Solution {
    public void dfs(int row,int col,int ans[][],int image[][],int ini,int delrow[],int delcol[],int newcolor){
        ans[row][col]=newcolor;
        int m=image.length;
        int n=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]==ini && ans[nrow][ncol]!=newcolor){
                dfs(nrow,ncol,ans,image,ini,delrow,delcol,newcolor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int ini=image[sr][sc];
        int ans[][]= image;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dfs(sr,sc,ans,image,ini,delrow,delcol,color);
        return ans;
        
    }
}