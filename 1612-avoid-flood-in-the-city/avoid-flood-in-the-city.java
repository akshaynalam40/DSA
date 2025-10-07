class Solution {
    public int[] avoidFlood(int[] rains) {
        int ans[]= new int[rains.length];
        Arrays.fill(ans,1);
        TreeSet<Integer>st= new TreeSet<Integer>();
        HashMap<Integer,Integer>hm= new HashMap<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                st.add(i);
            }
            else{
                ans[i]=-1;
                if(hm.containsKey(rains[i])){
                    Integer it=st.ceiling(hm.get(rains[i]));
                    if(it==null){
                        return new int[0];
                    }
                ans[it]=rains[i];
                st.remove(it);
                }
                hm.put(rains[i],i);
            }
        }
        return ans;
    }
}