class Solution {
    public int findmax(int coins[][], int i, int j, int m, int n, int count, int dp[][][]) {

        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }

        if (dp[i][j][count] != Integer.MIN_VALUE) {
            return dp[i][j][count];
        }

        int curr = coins[i][j];

        // ✅ FIXED BASE CASE
        if (i == m - 1 && j == n - 1) {
            if (curr < 0 && count < 2) {
                return dp[i][j][count] = 0; // neutralize
            }
            return dp[i][j][count] = curr;
        }

        // Positive cell
        if (curr >= 0) {
            int right = findmax(coins, i, j + 1, m, n, count, dp);
            int down = findmax(coins, i + 1, j, m, n, count, dp);

            return dp[i][j][count] = curr + Math.max(right, down);
        }

        int ans = Integer.MIN_VALUE;

        // Option 1: take loss
        int right = findmax(coins, i, j + 1, m, n, count, dp);
        int down = findmax(coins, i + 1, j, m, n, count, dp);
        int value = curr + Math.max(right, down);

        ans = value;

        // Option 2: neutralize
        if (count < 2) {
            int rightN = findmax(coins, i, j + 1, m, n, count + 1, dp);
            int downN = findmax(coins, i + 1, j, m, n, count + 1, dp);

            int value2 = Math.max(rightN, downN);

            ans = Math.max(ans, value2);
        }

        return dp[i][j][count] = ans;
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int dp[][][] = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return findmax(coins, 0, 0, m, n, 0, dp);
    }
}