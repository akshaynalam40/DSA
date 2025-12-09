class Solution {
    private boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public int largestPrime(int n) {
        int sum=0,maxi=0;
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                sum+=i;
            }
            if(sum>n){
                break;
            }
            if(isPrime(sum)){
                maxi=sum;
            }
        }
        return maxi;
    }
}