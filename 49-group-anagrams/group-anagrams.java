class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        ArrayList<List<String>>al=new ArrayList<>();
        HashMap<String,List<Integer>>hm=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=strs[i];
            char ch[]=s.toCharArray();
            Arrays.sort(ch);
            s=new String(ch);
            if(!hm.containsKey(s)){
               hm.put(s,new ArrayList<>());
            }
            hm.get(s).add(i);
        }
    for(Map.Entry<String,List<Integer>>entry:hm.entrySet()){
            String key=entry.getKey();
           List<Integer> list = entry.getValue();
            ArrayList<String>ans=new ArrayList<>();
            for(int i=0;i<list.size();i++){
                   int ind=list.get(i);
                   ans.add(strs[ind]);
            }
            al.add(ans);

        }

        return al;

        
    }
}