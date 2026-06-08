class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int arr[]= new int[n];
        boolean visited[]= new boolean[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                arr[j++]=nums[i];
                visited[i]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot && visited[i]==false){
                arr[j++]=nums[i];
                visited[i]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                arr[j++]=nums[i];
            }
        }

        return arr;
    }
}