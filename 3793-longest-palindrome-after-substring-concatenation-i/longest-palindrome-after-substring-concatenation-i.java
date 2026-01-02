class Solution {
    public boolean isPalindrome(String res){
        int start=0;
        int end=res.length()-1;
        while(start<=end){
            if(res.charAt(start)==res.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;

    }
    public int longestPalindrome(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int maxi=1;
        String a="";
        String b="";
        String res="";
        if(isPalindrome(s)){
            maxi=Math.max(s.length(),maxi);
        }
        if(isPalindrome(t)){
            maxi=Math.max(t.length(),maxi);
        }
        for(int i=0;i<=n1;i++){
            for(int j=i;j<=n1;j++){
              a=s.substring(i,j);
            for(int k=0;k<=n2;k++){
                for(int p=k;p<=n2;p++){
                    b=t.substring(k,p);
                     res=a+b;
                    if(isPalindrome(res)){
                    maxi=Math.max(maxi,res.length());
                }
            }
            }
        }
        }
        return maxi;
        
    }
}