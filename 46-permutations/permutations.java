class Solution {
public void per(int num[],List<Integer> ds, List<List<Integer>> ans, boolean freq[]) {
        if (ds.size()==num.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0;i <num.length;i++) {
            if (!freq[i]) {
                freq[i]=true;
                ds.add(num[i]);
                per(num,ds,ans,freq);
                ds.remove(ds.size() - 1); 
                freq[i]=false;
            }
        }
}
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int n= nums.length;
        boolean freq[]=new boolean[n];
        per(nums,ds,ans,freq);
        return ans;
    }
}
