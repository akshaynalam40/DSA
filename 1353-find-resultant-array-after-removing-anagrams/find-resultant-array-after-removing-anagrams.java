class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String>al= new ArrayList<>();
        String arr[]= new String[n];
        for(int i=0;i<n;i++){
            char ch[]=words[i].toCharArray();
            Arrays.sort(ch);
            arr[i]=new String(ch);
        }
        al.add(words[0]);
        for(int i=1;i<n;i++){
            if(!arr[i-1].equals(arr[i])){
                al.add(words[i]);
            }
        }
        return al;
        
    }
}