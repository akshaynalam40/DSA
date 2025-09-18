class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        TreeMap<Integer,Integer>tm= new TreeMap<>();
        for(int i=0;i<m;i++){
            tm.put(nums1[i][0],nums1[i][1]);
        }
       for(int i=0;i<n;i++){
        if(tm.containsKey(nums2[i][0])){
            int value=tm.get(nums2[i][0]);
            value=value+nums2[i][1];
            tm.put(nums2[i][0],value);
        }
        else{
            tm.put(nums2[i][0],nums2[i][1]);
        }
      }
         int arr[][]= new int[tm.size()][2];
         int i=0;
        for(Integer key:tm.keySet()){
            arr[i][0]=key;
            arr[i][1]=tm.get(key);
            i++;
        }

        return arr;
        
    }
}