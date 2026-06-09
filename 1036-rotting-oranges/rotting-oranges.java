class pair{
    int row;
    int col;
    int tm;
    public pair(int row,int col,int tm){
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<pair>queue=new LinkedList<>();
        int vis[][]= new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                queue.add(new pair(i,j,0));
                vis[i][j]=2;
                }
                else{
                      vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cnt++;
                }
                
            }
        }
        int tm=0;
        int drow[]={-1,0,+1,0};
        int dcol[]={0,1,0,-1};
        int count=0;
        while(!queue.isEmpty()){
            int row=queue.peek().row;
            int col=queue.peek().col;
            int tim=queue.peek().tm;
            tm=Math.max(tm,tim);
            queue.remove();
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if((nrow>=0&&nrow<m) && (ncol>=0 && ncol<n) && (grid[nrow][ncol]==1) && (vis[nrow][ncol]==0)){
                    queue.add(new pair(nrow,ncol,tm+1));
                    vis[nrow][ncol]=2;
                    count++;

                }
            }
        }
        if(count!=cnt){
            return -1;
        }
        return tm;
    }
}