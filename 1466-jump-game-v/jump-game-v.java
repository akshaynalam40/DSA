class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int ans=0;
        int maxi=1;
        int dp[]=new int[n];
        for(int i=0;i<arr.length;i++){
              dp[i]=-1;
        }
        for(int i=0;i<n;i++){
            ans=find(arr,i,d,dp);
            maxi=Math.max(ans,maxi);
        }
        return maxi; 
    }
    public int find(int arr[],int i,int d,int dp[]){
        if(i>arr.length || i<0){
            return 0;
        }
        int right=0;
        int left=0;
           for(int j=i+1;j<=Math.min(i+d,arr.length-1);j++){
            if(arr[j]>=arr[i]){
                break;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            right=Math.max(right,find(arr,j,d,dp));
           }
            for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i]) {
                break;
            }
            if(dp[i]!=-1){
                return dp[i];
            }
            left=Math.max(left,find(arr, j, d,dp));
        }
        return dp[i]=1+Math.max(left,right);
    }
}