class Solution {
    public int factorial(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
             return 6;
        }
        if(n==4){
            return 24;
        }
        if(n==5){
            return 120;
        }
        if(n==6){
            return 720;
        }
        if(n==7){
            return 5040;
        }
        if(n==8){
            return 40320;
        }
        else{
            return 362880;
        }
    }
    public boolean isDigitorialPermutation(int n) {
        int[] freq1 = new int[10];
        int num = n;
        while(num>0){
            freq1[num % 10]++;
            num = num / 10;
        }
        int sum = 0;
        num = n;
        while(num>0){
            sum += factorial(num % 10);
            num = num / 10;
        }
        int[] freq2 = new int[10];
        while(sum>0){
            freq2[sum%10]++;
            sum=sum/10;
        }

        return Arrays.equals(freq1, freq2);
   
    }
}