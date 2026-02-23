class Solution {
    public int scoreDifference(int[] nums) {
        int first=0, second=0;
        int n = nums.length;
        boolean Active = true;
        for(int i=0; i<n; i++){
            if(nums[i]%2!=0){
                Active = !Active;
            }

            if(i%6==5){
                Active = !Active;
            }

            if(Active){
               first += nums[i];
            }
            else{
                second+= nums[i];
            }
        }

        return first-second;
    }
}