class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String,Integer>hm= new HashMap<>();
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].length()<k){
                continue;
            }
            else{
                String sub=words[i].substring(0,k);
                if(!hm.containsKey(sub)){
                    hm.put(sub,1);
                }
                else{
                    int ans=hm.get(sub);
                    ans=ans+1;
                    hm.put(sub,ans);
                }
            }
        }
        for(Map.Entry<String,Integer>entry:hm.entrySet()){
            if(entry.getValue()>1){
                count++;
            }
        }
        return count;

        
    }
}