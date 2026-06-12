class pair{
    String first;
    int second;
    public pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair>queue= new LinkedList<>();
        queue.add(new pair(beginWord,1));
        HashSet<String>set= new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!queue.isEmpty()){
            String  Word=queue.peek().first;
            int steps=queue.peek().second;
            queue.remove();
           if(Word.equals(endWord)){
            return steps;
           }
            for(int i=0;i<Word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedArray[]=Word.toCharArray();
                    replacedArray[i]=ch;
                    String replacedWord=new String(replacedArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new pair(replacedWord,steps+1));
                    }
                }
            }

        }
        return 0;

    }
}