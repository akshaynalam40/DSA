class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n=technique1.length;
        long total = 0;
        int[] diff = new int[n];
        for(int i=0;i<n;i++) 
        {
            diff[i]=technique1[i]-technique2[i];
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
         for(int i = 0;i < n;i++){
            hm.put(i, diff[i]);
        }
        List<Map.Entry<Integer, Integer>>al=new ArrayList<>(hm.entrySet());
        al.sort(Map.Entry.comparingByValue());
        for(int i=n-k;i<n;i++){
            int index=al.get(i).getKey();
            total+=technique1[index];
            technique1[index]=0;
            technique2[index]=0;
        }
        for(int i=0;i<n;i++){
             total+=Math.max(technique1[i], technique2[i]);
        }
         return total;
    }
}
