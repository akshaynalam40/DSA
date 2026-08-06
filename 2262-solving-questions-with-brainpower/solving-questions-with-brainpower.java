class Solution {
    Long[] dp;

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new Long[n];
        return solve(questions, 0);
    }

    private long solve(int[][] questions, int idx) {
        if (idx >= questions.length)
            return 0;

        if (dp[idx] != null)
            return dp[idx];

        long pick = questions[idx][0];
        int next = idx + questions[idx][1] + 1;

        pick += solve(questions, next);

        long notPick = solve(questions, idx + 1);

        return dp[idx] = Math.max(pick, notPick);
    }
}