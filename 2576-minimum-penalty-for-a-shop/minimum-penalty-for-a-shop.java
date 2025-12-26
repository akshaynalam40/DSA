class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int pre[]= new int[n+1];
        int suff[]= new int[n+1];
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='N'){
                pre[i+1]=pre[i]+1;
            }
            else{
                pre[i+1]=pre[i];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(customers.charAt(i)=='Y'){
                suff[i]=suff[i+1]+1;
            }
            else{
                suff[i]=suff[i+1];
            }
        }
        int mini=Integer.MAX_VALUE;
        int ind=0;
        for(int i=0;i<=n;i++){
            int ans=pre[i]+suff[i];
            if(ans<mini){
                mini=ans;
                ind=i;
            }
        }
        return ind;
    }
}