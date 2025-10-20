class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        int res=10;
        int uniquedigits=9;
        int remain=9;
        for(int i=1;i<n;i++){
            uniquedigits*=remain;
            res+=uniquedigits;
            remain--;
        }
        return res;
    }
}