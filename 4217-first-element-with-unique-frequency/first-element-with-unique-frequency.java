class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>hm= new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        HashMap<Integer,ArrayList<Integer>>store=new HashMap<>();
        for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
        int key=entry.getKey();
        int val=entry.getValue();
        if(!store.containsKey(val)){
            ArrayList<Integer>list=new ArrayList<>();
            list.add(key);
            store.put(val,list);
        }
        else{
            store.get(val).add(key);
        }
        }
        for(int i = 0; i < n; i++){
            int frequency = hm.get(nums[i]);
            if (store.get(frequency).size() == 1) {
                return nums[i];
            }
        }
        return -1;
        
    }
}