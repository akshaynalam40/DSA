class Solution {
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int maxpro=1;
        while(n>4){
          maxpro=maxpro*3;
          n=n-3;
        }
        maxpro=maxpro*n;
        return maxpro;
    }
}