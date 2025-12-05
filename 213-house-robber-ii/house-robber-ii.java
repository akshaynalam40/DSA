class Solution {
    public int find(int ind, int arr[], int dp[]) {
        if (ind == 0) return arr[0];
        if (ind < 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int pick = arr[ind] + find(ind - 2, arr, dp);
        int notpick = find(ind - 1, arr, dp);

        return dp[ind] = Math.max(pick, notpick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int arr1[] = Arrays.copyOfRange(nums, 0, n - 1);
        int arr2[] = Arrays.copyOfRange(nums, 1, n);
        int dp1[] = new int[n - 1];
        int dp2[] = new int[n - 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int ans1 = find(n - 2, arr1, dp1);
        int ans2 = find(n - 2, arr2, dp2);
        return Math.max(ans1, ans2);
    }
}
