class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n=prices.length;
        int m=discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i=n-1;
        int j=m-1;
        double ans=0;
        while(i>=0 && j>=0){
           ans+=((double)prices[i]*(100-discounts[j])/100);
           i--;
           j--;
        }
        while(i>=0){
            ans+=prices[i];
            i--;
        }
        return ans;
    }
}