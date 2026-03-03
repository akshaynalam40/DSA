class Solution {
    public String reverse(String s){
        int start=0,end=s.length()-1;
        char ch[]=s.toCharArray();
        while(start<=end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        return new String(ch);
    }
    public String invert(String s){
        char ch[]=s.toCharArray();
        int len=ch.length;
        for(int i=0;i<len;i++){
            if(ch[i]=='0'){
                ch[i]='1';
            }
            else{
                ch[i]='0';
            }
        }
        return new String(ch);
    }
    public char findKthBit(int n, int k) {
         String  s1="0";
         String s2;
         int i=1;
         while(i<=n){
            String rev=reverse(invert(s1));
            s2=s1+"1"+rev;
            s1=s2;
            i++;
         }
         return s1.charAt(k-1);
    }
}