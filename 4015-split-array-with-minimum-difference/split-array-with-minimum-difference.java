class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long mini=0;
        if(n<2){
            return 0;
        }
        if(n==2){
            return Math.abs(nums[0] - nums[1]);
        }
        long prefixSum=0;
        long suffixSum=0;
        int i=0,j=n-1;
        while(i<n-1 && nums[i]<nums[i+1]){
            prefixSum+=nums[i];
            i++;
        }
        while(j>0 && nums[j]<nums[j-1]){
            suffixSum+=nums[j];
            j--;
        }
        if(i==j){
            long ans1=Math.abs((prefixSum+nums[i])-suffixSum);
            long ans2=Math.abs((suffixSum+nums[j]-prefixSum));
            mini=Math.min(ans1,ans2);  
            return mini;
        }
        else if(nums[i]==nums[j] && (j-i)==1){
            mini= Math.abs(prefixSum-suffixSum);
            return mini;
        }
        else{
            return -1;
          }
    }
}

