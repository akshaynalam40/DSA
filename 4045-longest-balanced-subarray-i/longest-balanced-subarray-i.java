class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
         HashSet<Integer>os=new HashSet<>();
          HashSet<Integer>es=new HashSet<>();
          for(int j=i;j<n;j++){
            if(nums[j]%2==0){
                es.add(nums[j]);
            }
            else{
                os.add(nums[j]);
            }
            if(os.size()==es.size()){
                max=Math.max(j-i+1,max);
            }
            
          }
         
        }
        return max;
    }
}