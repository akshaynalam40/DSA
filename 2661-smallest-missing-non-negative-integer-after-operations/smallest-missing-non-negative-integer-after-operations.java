class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int freq[]= new int[value];
        int n=nums.length;
        for(int i=0;i<n;i++){
            int ele =((nums[i] % value) + value)%value;
            freq[ele]++;
        }
        int max=0;
        while(true){
            int i=max%value;
            if(freq[i]==0){
                 break;
            }
            freq[i]--;
            max++;
        }

     return max;
    
    }
}