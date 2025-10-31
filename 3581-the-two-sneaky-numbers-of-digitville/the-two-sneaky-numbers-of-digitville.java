class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2];
        HashMap<Integer,Integer>hm= new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int i=0;
        for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
            if(entry.getValue()==2){
                arr[i++]=entry.getKey();
            }
        }
        return arr;
    }
}