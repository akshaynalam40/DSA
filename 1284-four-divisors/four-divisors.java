class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>hm= new HashMap<>();
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                res+=hm.get(nums[i]);
            }
            else{
            ArrayList<Integer>al=new ArrayList<>();
            int count=0;
            for(int j=1;j<=nums[i];j++){
               if(nums[i]%j==0){
                al.add(j);
                count++;
               }
               if(count==5){
                break;
               }
               
            }
             int sum=0;
            if(al.size()==4){
                sum+=al.get(0);
                sum+=al.get(1);
                sum+=al.get(2);
                sum+=al.get(3);
            }
            hm.put(nums[i],sum);
            res+=sum;
        }
        }

        return res;
    }
}