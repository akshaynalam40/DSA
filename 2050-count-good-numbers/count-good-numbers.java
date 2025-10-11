class Solution {
    public long mod=(long)((Math.pow(10,9))+7);
    public int countGoodNumbers(long n) {
        long odd=n/2;
        long even=(n-n/2);
        long ans=0;
        ans=pow(5,even,mod)*pow(4,odd,mod);
        ans=ans%mod;
        return (int)ans;
    }
    public long pow(long base,long exp,long mod){
        long result=1;
        base%=mod;
        while(exp>0){
            if(exp%2==1){
                result=(result*base)%mod;
                exp--;
            }
            else{
                base=(base*base)%mod;
                exp=exp/2;
            }
        }
        return result;
    }
}