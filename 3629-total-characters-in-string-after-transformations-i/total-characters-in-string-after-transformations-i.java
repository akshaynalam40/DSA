class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int n = s.length();
        long arr[] = new long[26];
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int j= 0;j< t;j++) {
            long  temp[]=new long[26];
             for(int i=0;i<26;i++){
                if(i==25){
                    temp[0]=(temp[0]+arr[i])%mod;
                    temp[1]=(temp[1]+arr[i])%mod;
                }
                else{
                    temp[i+1]=(temp[i+1]+arr[i])%mod;
                }
             }
             arr=temp;
        }
        long len = 0;
        for (int i = 0; i < 26; i++) {
            len = (len + arr[i]) % mod;
        }

        return (int) len;
    }

}
