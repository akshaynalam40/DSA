class Solution {
    public int findways(int nums[],int sum,int ind,int target){
        if(ind==0){
             int count=0;
             if(sum+nums[ind]==target){
                count++;
             }
             if(sum-nums[ind]==target){
                count++;
             }
             return count;

        }
        int plus=findways(nums,sum+nums[ind],ind-1,target);
        int sub=findways(nums,sum-nums[ind],ind-1,target);
        return plus+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        int ans=findways(nums,sum,n-1,target);
        return ans;
    }

}