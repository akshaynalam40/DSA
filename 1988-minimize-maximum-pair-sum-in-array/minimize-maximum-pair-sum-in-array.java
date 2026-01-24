class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxi=0;
        int i=0,j=n-1;
        while(i<j){
            maxi=Math.max(nums[i]+nums[j],maxi);
            i++;
            j--;
        }
        return maxi;
    }
}