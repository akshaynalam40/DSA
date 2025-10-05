class Solution {
    public int alternatingSum(int[] nums) {
        int n=nums.length;
        int sign;
        int sum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                sign=1;
            }
            else{
                sign=-1;
            }
            sum+=sign*nums[i];
        }
        return sum;
    }
}