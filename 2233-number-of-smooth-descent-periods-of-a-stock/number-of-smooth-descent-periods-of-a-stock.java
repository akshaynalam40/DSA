class Solution {
    public long getDescentPeriods(int[] prices) {
        long n=prices.length;
        long count=1;
        long sum=1;
        if(n==1){
            return 1;
        }
        for(int i=1;i<n;i++){
            if(prices[i-1]-prices[i]==1){
             count++;
            }
            else{
                count=1;
            }
            sum+=count;
        }
        return sum;
    }
}