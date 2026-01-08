class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        int n =s.length();
        int len=n/k;
        for(int i=0;i<n;i+=len){
            String sub=t.substring(i, i + len);
            hm.put(sub,hm.getOrDefault(sub, 0) + 1);
        }
        for(int i= 0;i<n;i+= len){
            String sub=s.substring(i,i+len);
            if(!hm.containsKey(sub)){
                return false;
            }
            hm.put(sub,hm.get(sub) - 1);
            if(hm.get(sub)==0){
               hm.remove(sub);
            }
        }

        return true;
    }
}
