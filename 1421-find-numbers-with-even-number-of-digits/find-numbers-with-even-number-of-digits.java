class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int x=nums[i];
            int cnt=0;
            while(x!=0){
                x=x/10;
                cnt++;
            }
            if(cnt%2==0){
                count++;
            }
        }
        return count;
    }
}