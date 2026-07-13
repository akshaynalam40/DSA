class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(m>n){
            return false;
        }
        int pre[]= new int[n+1];
        int suff[]= new int[n+1];
        int idx=0;
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i];
            if(idx<m){
                if(s.charAt(idx)==t.charAt(i)){
                    pre[i+1]++;
                    idx++;
                }
            }
        }
        idx=m-1;
        for(int j=n-1;j>=0;j--){
            suff[j]=suff[j+1];
            if(idx>=0 && s.charAt(idx)==t.charAt(j)){
                idx--;
                suff[j]++;
            }
        }
        for(int i=0;i<n;i++){
            if(pre[i]+suff[i]==m){
                return true;
            }
            if(pre[i]+suff[i+1]>=m-1){
                return true;
            }
        }
        return false;
    }
}