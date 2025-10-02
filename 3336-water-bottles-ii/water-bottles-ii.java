class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans=0;
        int remain=0;
        ans+=numBottles;
        remain+=numBottles;
        while(remain>=numExchange){
            ans++;
            remain-=numExchange;
            remain++;
            numExchange++;
        }
      return ans;  
    }
}