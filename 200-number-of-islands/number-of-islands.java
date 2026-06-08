import java.util.*;

class pair {
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public void bfs(int ro, int co, char[][] grid, int[][] vis) {

        vis[ro][co] = 1;

        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(ro, co));

        int m = grid.length;
        int n = grid[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            pair curr = queue.poll();
            int row = curr.first;
            int col = curr.second;

            for (int i = 0; i < 4; i++) {

                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if (nrow >= 0 && nrow < m &&
                    ncol >= 0 && ncol < n &&
                    grid[nrow][ncol] == '1' &&
                    vis[nrow][ncol] == 0) {

                    vis[nrow][ncol] = 1;
                    queue.add(new pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return count;
    }
}