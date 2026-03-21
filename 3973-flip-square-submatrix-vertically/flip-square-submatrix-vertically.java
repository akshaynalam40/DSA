class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Copy original grid
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[i][j];
            }
        }

        // Start from bottom row of the submatrix
        int s = x + k - 1;
        for (int i = x; i < x + k; i++) {
            int l = y;
            for (int j = y; j < y + k; j++) {
                grid[i][j] = arr[s][l++];
            }
            s--; // move upwards
        }

        return grid;
    }
}
