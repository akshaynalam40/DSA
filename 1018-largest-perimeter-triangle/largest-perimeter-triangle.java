class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=0;
        int k=n-1;
        int j=n-2;
        int i=n-3;
        while(nums[k]>=nums[i]+nums[j]){
            if(k<=2){
                return 0;
            }
            k--;
            j--;
            i--;
        }
        return nums[i]+nums[j]+nums[k];
    }
}