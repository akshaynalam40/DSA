class Solution {
    private long Dist(int a, int b, int h) {
        int d =Math.abs(a-b);
        return Math.min(d,h-d);
    }
    public long minMoves(int[] balance) {
        int n=balance.length;
        long count = 0;
        int ind = -1;
        int neg = 0;
        long sum = 0;
        for(int k = 0; k < n; k++) {
            sum += balance[k];
            if (balance[k] < 0) {
                ind = k;
                neg++;
            }
        }

        if(neg>1){
            return -1;
        }
        if(neg==0){
            return 0;
        }
        if(sum<0){
            return -1;
        }
        long ele=balance[ind];
        int i=(ind-1+n)%n;
        int j=(ind + 1)%n;
        int visited=0;
        while (ele<0&&visited<n) {
            if(balance[i]>0&&ele<0) {
                long take=Math.min(balance[i], -ele);
                balance[i]-=take;
                ele += take;
                count +=take*Dist(i,ind,n);
            }
            if(balance[j]> 0&&ele<0) {
                long take=Math.min(balance[j], -ele);
                balance[j]-=take;
                ele+=take;
                count+=take * Dist(j, ind, n);
            }

            i=(i - 1 + n) % n;
            j=(j + 1) % n;
            visited++;
        }

        if(ele<0) {
            return -1;
        }
        return count;
    }
}
