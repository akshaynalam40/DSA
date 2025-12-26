class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        long last=(long)(-1e9);
        for(int num:nums){
            long low=(long)num-k;
            long high=(long)num+k;
            long pick=Math.max(low,last+1);
            if(pick<=high){
                count++;
                last=pick;
            }
        }
        return count;
        
    }
}