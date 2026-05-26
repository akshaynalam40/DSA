class TrieNode{
    TrieNode children[];
    boolean isEndofWord;
    TrieNode(){
        children=new TrieNode[26];
        isEndofWord=false;
    }

}
class Trie {
   private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode current=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            int index=ch-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
           current=current.children[index];
        }
        current.isEndofWord=true;
    }
    
    public boolean search(String word) {
        TrieNode current=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            int index=word.charAt(i)-'a';
            if(current.children[index]==null){
                return false;
            }
            current= current.children[index];
        }
       return current.isEndofWord;
    }
    public boolean startsWith(String prefix) {
        TrieNode current=root;
        int n=prefix.length();
        for(int i=0;i<n;i++){
            int index=prefix.charAt(i)-'a';
            if(current.children[index]==null){
                return false;
            }
            current=current.children[index];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */