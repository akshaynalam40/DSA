class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int ans[]= new int[n];
        int total=0;
        for(int x:nums){
           total+=x;
        }
        int prev=0;
        for(int i=0;i<n;i++){
            total=total-nums[i];
            ans[i]=Math.abs(prev-total);
            prev+=nums[i];
        }
        return ans;
    }
}