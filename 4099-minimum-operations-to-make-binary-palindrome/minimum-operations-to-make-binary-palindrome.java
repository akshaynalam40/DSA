class Solution {
    public int checkpalindrome(int num){
        int x=num;
        int y=num;
        int count1=0;
        int count2=0;
        while(true){
        String binary = Integer.toBinaryString(x);
        String reversed = new StringBuilder(binary).reverse().toString();
         if(binary.equals(reversed)){
           break;
         }
         count1++;
         x++;
        }
        while(y>=0){
        String binary = Integer.toBinaryString(y);
        String reversed = new StringBuilder(binary).reverse().toString();
         if(binary.equals(reversed)){
           break;
         }
         count2++;
         y--;
        }
     return Math.min(count1,count2);

    }
    public int[] minOperations(int[] nums) {
        int n= nums.length;
        int ans[]= new int[n];
        for(int i=0;i<n;i++){
            int answer=checkpalindrome(nums[i]);
            ans[i]=answer;
        }
        return ans;
    }
}