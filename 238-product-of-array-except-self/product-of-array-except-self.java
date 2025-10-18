class Solution {
    public int[] productExceptSelf(int[] nums) {
      int n=nums.length;
      int ans[]= new int[n];
      int pre[]=new int[n+1];
      int suff[]= new int[n+1];
      int pr=1;
      int suf=1;
      for(int i=0;i<n;i++){
        pre[i]=pr;
        pr=pr*nums[i];
      }
      for(int i=n-1;i>=0;i--){
        suff[i]=suf;
        suf=suf*nums[i];
      }
      for(int i = 0; i < n; i++) {
        ans[i] = pre[i] * suff[i];
     }
      return ans;
    }
}