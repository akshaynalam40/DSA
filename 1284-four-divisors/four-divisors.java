class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer>hm = new HashMap<>();
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < n; i++){
            if(hm.containsKey(nums[i])){
                res += hm.get(nums[i]);
            } 
            else{
                ArrayList<Integer> al = new ArrayList<>();
                int count = 0;
                int num = nums[i];
                for(int j = 1;j*j <= num;j++){
                    if (num % j == 0) {
                        int d1 = j;
                        int d2 = num/j;
                        al.add(d1);
                        count++;
                        if(d1!=d2) {
                            al.add(d2);
                            count++;
                        }
                    }
                    if(count>4){
                        break;
                    }
                }

                int sum = 0;
                if(al.size() == 4){
                    sum += al.get(0);
                    sum += al.get(1);
                    sum += al.get(2);
                    sum += al.get(3);
                }

                hm.put(num, sum);
                res += sum;
            }
        }
        return res;
    }
}
