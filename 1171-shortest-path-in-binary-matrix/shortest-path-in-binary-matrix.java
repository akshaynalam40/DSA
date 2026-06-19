class tuple{
    int distance;
    int row;
    int col;
    public tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dis[][]= new int[m][n];
        if(grid[0][0]==1 || grid[m-1][n-1]==1){
            return -1;
        }
        if(m==1 && n==1){
            return 1;
        }
        for(int i=0;i<m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Queue<tuple>queue=new LinkedList<>();
        queue.offer(new tuple(1,0,0));
        dis[0][0]=1;
        int delrow[]={0,1,1,1,0,-1,-1,-1};
        int delcol[]={1,1,0,-1,-1,-1,0,1};
        while(!queue.isEmpty()){
            tuple val=queue.poll();
            int a=val.distance;
            int ro=val.row;
            int co=val.col;
            for(int i=0;i<8;i++){
                int n_row=ro+delrow[i];
                int n_col=co+delcol[i];
                if(n_row>=0 && n_row<m && n_col>=0 && n_col<n && grid[n_row][n_col]==0){
                    if(dis[n_row][n_col]>1+a){
                        dis[n_row][n_col]=1+a;
                        queue.offer(new tuple(1+a,n_row,n_col));
                        if(n_row==m-1 && n_col==n-1){
                            return 1+a;
                        }
                    }
                }
            }

        }
       return -1;

    }
}