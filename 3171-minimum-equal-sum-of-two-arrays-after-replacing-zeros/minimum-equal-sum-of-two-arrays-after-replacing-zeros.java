class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
         long sum1=0;
         long sum2=0;
         int count1=0,count2=0;
         for(int i=0;i<n1;i++){
            if(nums1[i]==0){
                count1++;
                nums1[i]=1;
            }
            sum1+=nums1[i];
         }
         for(int i=0;i<n2;i++){
            if(nums2[i]==0){
                count2++;
                nums2[i]=1;
            }
            sum2+=nums2[i];
         }
         if(((sum1>sum2)&&count2==0) || ((sum2>sum1)&&count1==0)){
            return -1;
         }
         return Math.max(sum1,sum2);
    }
}