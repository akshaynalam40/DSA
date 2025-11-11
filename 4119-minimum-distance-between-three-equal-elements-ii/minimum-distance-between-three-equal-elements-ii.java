class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(nums[i],arr);
            }
            else{
                map.get(nums[i]).add(i);
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for(Integer key : map.keySet()){
            ArrayList<Integer> arr = map.get(key);
            
            if(arr.size() < 3)continue;

            for(int i = 0;i<=arr.size()-3;i++){
                int first = arr.get(i);
                int second = arr.get(i+1);
                int third = arr.get(i+2);
                
                int curr = Math.abs(first-second)+ Math.abs(second-third)+Math.abs(third-first);
                minDistance = Math.min(curr,minDistance);
            }
        }

        if(minDistance==Integer.MAX_VALUE)return -1;
        return minDistance;
    }
}