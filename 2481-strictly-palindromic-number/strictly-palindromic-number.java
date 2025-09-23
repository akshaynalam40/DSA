class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int base=2;
        while(base<=n-2){
            String s=Integer.toString(n);
            String str= new StringBuilder(Integer.toString(n,base)).reverse().toString();
            if(!s.equals(str)){
                return false;
            }
            base++;
        }
        return true;
    }
}