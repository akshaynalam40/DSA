class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        for(int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } 
            else {
                pre[i] = 1;
            }
        }
        suff[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                suff[i] = suff[i + 1] + 1;
            } 
            else {
                suff[i] = 1;
            }
        }

        int ans = 1;
        for(int i = 1;i < n;i++) {
            ans = Math.max(ans, Math.min(pre[i - 1], suff[i]));
        }
        return ans;
    }
}
