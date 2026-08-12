class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int low=0;
        HashMap<Integer,Integer>hm= new HashMap<>();
        int  l=0;
        int r=0;
        int maxi=1;
        for(r=0;r<n;r++){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.get(nums[r])>k){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0){
                    hm.remove(nums[l]);
                }
                l++;
            }
          maxi=Math.max(r-l+1,maxi);
        }
        return maxi;
    }
}