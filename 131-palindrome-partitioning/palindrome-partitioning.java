class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        List<String>ans=new ArrayList<>();
        func(0,s,ans,res);
        return res;
    }
    public void func(int index,String s,List<String>ans,List<List<String>>res){
          if(index==s.length()){
            res.add(new ArrayList<>(ans));
            return;
          }
    for(int i=index;i<s.length();i++){
        if(isPalindrome(s,index,i)){
            ans.add(s.substring(index,i+1));
            func(i+1,s,ans,res);
            ans.remove(ans.size()-1);
        }
    }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}