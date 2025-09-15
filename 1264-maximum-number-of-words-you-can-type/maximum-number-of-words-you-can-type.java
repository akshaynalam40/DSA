class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character>hs= new HashSet<>();
        int n=brokenLetters.length();
        for(int i=0;i<n;i++){
            hs.add(brokenLetters.charAt(i));
        }
        String arr[]=text.split(" ");
        int count=0;
        for(int i=0;i<arr.length;i++){
            String str=arr[i];
            for(int j=0;j<str.length();j++){
                if(hs.contains(str.charAt(j))){
                    count++;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        return arr.length-count;
        
    }
}