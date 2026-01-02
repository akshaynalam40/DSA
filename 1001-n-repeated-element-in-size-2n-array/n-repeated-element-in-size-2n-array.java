class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        HashSet<Integer>hs= new HashSet<>();
        for(int i=0;i<n;i++){
            if(hs.contains(nums[i])){
                return nums[i];
            }
            hs.add(nums[i]);
        }
        return 0;
        
    }
}