class Solution {
    Long dp[][][];
    public long maxScore(int[] nums1, int[] nums2, int k) {
        dp = new Long[nums1.length][nums2.length][k + 1];
        return helper(nums1, nums2, 0, 0, k);
    }

    public long helper(int[] a, int[] b, int i, int j, int k){
        if(k == 0) return 0;
        if(i >= a.length || j >= b.length) return (long) -1e18;
        if(dp[i][j][k] != null) return dp[i][j][k];

        long take = ((long) a[i] * b[j]) + helper(a, b, i + 1, j + 1, k - 1);
        long skipA = helper(a, b, i + 1, j, k);
        long skipB = helper(a, b, i, j + 1, k);
        return dp[i][j][k] = Math.max(take, Math.max(skipA, skipB));
    }
}