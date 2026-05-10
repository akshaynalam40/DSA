class Solution {
    public boolean isLetter(char ch){
        return ch >= 'a' && ch <= 'z';
    }
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb = new StringBuilder();
        for(String part : chunks) {
            sb.append(part);
        }
        String s=sb.toString();
        HashMap<String, Integer> hm = new HashMap<>();
        int n=s.length();
        int i=0;
        while(i<n){
            if(!isLetter(s.charAt(i))){
                i++;
                continue;
            }
            StringBuilder word = new StringBuilder();

            while(i < n){

                char ch = s.charAt(i);
                if(isLetter(ch)) {
                    word.append(ch);
                    i++;
                }

                else if(ch == '-'){
                    boolean left =word.length() > 0;
                    boolean right=
                        (i+1<n&&
                         isLetter(s.charAt(i + 1)));
                    if(left&&right){
                      word.append('-');
                        i++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
            String w = word.toString();
            hm.put(w,
                     hm.getOrDefault(w, 0) + 1);
        }
        int[] ans=new int[queries.length];
        for (int j = 0;j<queries.length;j++) {
            ans[j]=hm.getOrDefault(queries[j], 0);
        }
        return ans;
    }
}