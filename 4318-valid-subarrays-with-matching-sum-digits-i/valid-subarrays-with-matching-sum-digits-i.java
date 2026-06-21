class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                String s=Long.toString(sum);
                if(s.charAt(0)==(char)(x+'0') && s.charAt(s.length()-1)==(char)(x+'0')){
                    count++;
                }
            }
        }
        return count;
    }
}