class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        HashMap<Character,Integer>small=new HashMap<>();
        HashMap<Character,Integer>capital=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(ch>='a' && ch<='z'){
                small.put(ch,i);
    
            }
            else{
                capital.putIfAbsent(ch,i);
            }
        }
        int count = 0;
        for(char ch:small.keySet()){
            char big=(char)(ch-'a'+'A');
            if(capital.containsKey(big)) {
                if (small.get(ch)<capital.get(big)) {
                    count++;
                }
            }
        }
        return count;
            }
}