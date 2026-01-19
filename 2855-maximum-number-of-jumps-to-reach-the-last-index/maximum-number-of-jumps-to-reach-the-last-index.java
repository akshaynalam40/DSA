class Solution {
    public int find(int[] nums, int target, int i, int j,int dp[][]) {
        if(i==0){
            if(Math.abs(nums[j]-nums[i])<=target){
                return 1;
            }
            return -1;
        }
        if(dp[i][j]!=-2){
            return dp[i][j];
        }
        int max = -1;
        if(Math.abs(nums[j] - nums[i]) <= target) {
            for (int k = i - 1; k >= 0; k--) {
                int res = find(nums, target, k, i,dp);
                if(res != -1){
                    max = Math.max(max, res + 1);
                }
            }
        }
        return dp[i][j]=max;
    }

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int maxi = -1;
        int j = n - 1;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-2);
        }
        for (int i = n - 2; i >= 0; i--) {
            int ans = find(nums, target, i, j,dp);
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }
}
