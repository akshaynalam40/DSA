class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=0;
        int remain=0;
        while(numBottles>0){
            ans+=numBottles;
            remain+=numBottles;
            numBottles=remain/numExchange;
            remain=remain%numExchange;
        }
        return ans;
    }
}