class Solution {
    public int count(int mid,int m,int n){
        int total=0;
        for(int i=1;i<=m;i++){
            total+=Math.min(n,mid/i);
        }
        return total;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1;
        int high=m*n;
        while(low<high){
            int mid=low+(high-low)/2;
            int val=count(mid,m,n);
            if(val>=k){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
       return low;
        
    }
}