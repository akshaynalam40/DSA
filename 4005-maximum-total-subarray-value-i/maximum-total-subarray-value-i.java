class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long total=0;
        long min=nums[0];
        long max=nums[0];
        for(int i=1;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        total=k*(max-min);
        return total;
    }
}