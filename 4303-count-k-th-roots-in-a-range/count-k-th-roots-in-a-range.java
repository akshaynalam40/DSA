class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k==1){
            return r-l+1;
        }
        int count=0;
        int max=(int)Math.pow(r,1.0/k)+1;
        for(int x=0;x<=max;x++){
            long y=Math.round(Math.pow(x,k));
            if(l<=y && y<=r){
                count++;
            }
        }
       
    return count;
    }
}