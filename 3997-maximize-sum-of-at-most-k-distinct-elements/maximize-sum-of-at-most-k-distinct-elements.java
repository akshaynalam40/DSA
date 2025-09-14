class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer>hs= new HashSet<>();
        int n=nums.length;
        while(hs.size()<k && n>0){
            hs.add(nums[n-1]);
            n--;
        }
        int arr[]=  new int[hs.size()];
        int l=0;
        for(int j:hs){
         arr[l++]=j;
        }
        Arrays.sort(arr);
        int lw=0,r=arr.length-1;
        while(lw<r){
            int temp=arr[lw];
            arr[lw]=arr[r];
            arr[r]=temp;
            lw++;
            r--;
        }   
        return arr;
    }
}