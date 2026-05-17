class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean flag[]=new boolean[n];
     boolean ans=findreach(arr,start,flag);
        return ans;
    }
    public boolean findreach(int arr[],int ind,boolean []flag){
        if(ind>=arr.length || ind<0){
            return false;
        }
        if(flag[ind]){
            return false;
        }
        if(arr[ind]==0){
            return  true;
        }
        flag[ind]=true;
        boolean first=findreach(arr,ind+arr[ind],flag);
        boolean second=findreach(arr,ind-arr[ind],flag);
        return first||second;
    }
}