class pair{
    int first;
    int second;
    int third;
    public pair(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int vis[][]= new int[m][n];
        int dis[][]= new int[m][n];
        Queue<pair>queue= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                vis[i][j]=1;
                queue.add(new pair(i,j,0));
                }
            }
        }
        int delrow[]= {-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!queue.isEmpty()){
            int row=queue.peek().first;
            int col=queue.peek().second;
            int steps=queue.peek().third;
            queue.remove();
            dis[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                     vis[nrow][ncol]=1;
                     queue.add(new pair(nrow,ncol,steps+1));
                }
            }
        }
        return dis;
    }
}