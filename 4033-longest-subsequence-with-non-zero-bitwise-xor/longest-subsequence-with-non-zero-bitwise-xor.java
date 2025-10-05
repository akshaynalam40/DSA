class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int ans=0;
        boolean zero_check= false;
        for(int i=0;i<n;i++){
              ans^=nums[i];
              if(nums[i]!=0){
                zero_check =true;
              }
        }
        if(ans!=0){
            return n;
        }
        return zero_check?n-1:0; 
    }
}