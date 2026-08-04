class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer>al= new ArrayList<>();
        HashSet<Integer>hs= new HashSet<>();
        Arrays.sort(nums);
        int start=nums[0];
        int end=nums[nums.length-1];
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        } 
        int i=start;
        while(i<=end){
            if(!hs.contains(i)){
                al.add(i);
            }
            i++;
        }
        return al;
    }
}