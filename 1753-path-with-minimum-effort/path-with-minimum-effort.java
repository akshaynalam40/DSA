class tuple {
    int diff;
    int row;
    int col;
    public tuple(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<tuple>pq =new PriorityQueue<>((a,b)->Integer.compare(a.diff, b.diff));
        dist[0][0] = 0;
        pq.offer(new tuple(0, 0, 0));
        int[] delrow ={0, 1, 0, -1};
        int[] delcol ={1, 0, -1, 0};
        while(!pq.isEmpty()) {
            tuple curr = pq.poll();
            int effort = curr.diff;
            int row = curr.row;
            int col = curr.col;
            if(row==m-1&&col==n-1) {
                return effort;
            }
            for(int i=0;i<4;i++){
                int nr=row + delrow[i];
                int nc=col + delcol[i];
                if(nr>=0&&nr<m &&nc>=0 &&nc<n){
                    int newEffort = Math.max(
                        effort, Math.abs(
                            heights[row][col]
                           - heights[nr][nc] )
                    );
                    if(newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;

                        pq.offer(
                            new tuple(newEffort, nr, nc)
                        );
                    }
                }
            }
        }

        return 0;
    }
}