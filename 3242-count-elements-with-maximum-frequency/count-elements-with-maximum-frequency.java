class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer>hm= new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int max=0;
        int total=0;
        for(int key:hm.keySet()){
            int ans=hm.get(key);
            if(ans>max){
                max=ans;
                total=ans;
            }
            else if(ans==max){
                total+=ans;
            }
        }
        return total;
    }
}