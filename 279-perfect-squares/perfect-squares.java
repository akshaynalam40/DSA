class Solution {
    public int findMin(int ind,int arr[],int n,int sum,int dp[][]){
        if(sum==n){
            return 0;
        }
        if(sum>n || ind>=arr.length){
            return Integer.MAX_VALUE;
        }
        if(dp[ind][sum]!=-1){
            return dp[ind][sum];
        }
        int samepick=findMin(ind,arr,n,sum+arr[ind],dp);
        if(samepick!=Integer.MAX_VALUE){
            samepick++;
        }
        int notpick=findMin(ind+1,arr,n,sum,dp);

        return dp[ind][sum]=Math.min(samepick,notpick);
    }
    public int numSquares(int n) {
        ArrayList<Integer>al= new ArrayList<>();
        int i=1;
        while(i*i<=n){
           al.add(i*i);
               i++;
        }
        int size=al.size();
        int arr[]=new int[size];
        for(i=0;i<size;i++){
            arr[i]=al.get(i);
        }
        int dp[][]=new int[size][n+1];
        for(i=0;i<size;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum=0;
           int min=findMin(0,arr,n,0,dp);
           return min;
        
    }
}