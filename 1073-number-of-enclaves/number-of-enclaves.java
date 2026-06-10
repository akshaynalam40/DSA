class pair{
    int first;
    int second;
    public pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]= new int[m][n];
        Queue<pair>queue= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||i==m-1 ||j==0 || j==n-1){
                    if(grid[i][j]==1){
                        vis[i][j]=1;
                        queue.add(new pair(i,j));
                    }
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!queue.isEmpty()){
            int row=queue.peek().first;
            int col=queue.peek().second;
            queue.remove();
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    queue.add(new pair(nrow,ncol));
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                   count++;
                }
            }
        }
        return count;
        
    }
}