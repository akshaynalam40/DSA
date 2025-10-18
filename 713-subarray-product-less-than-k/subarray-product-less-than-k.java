class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int left=0,right=0;
        int count=0;
        long pro=1;
        if(k<=1){
            return 0;
        }
        while(right<n){
            pro=pro*nums[right];
            while(pro>=k){
                pro=pro/nums[left];
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}