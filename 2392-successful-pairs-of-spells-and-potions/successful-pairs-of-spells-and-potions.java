class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        int ans[]= new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            ans[i]=countPairs(spells[i],potions,success,m);
        }
       
       return ans; 
    }
    public int countPairs(int spell,int[] potions,long success,int m){
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            if((long)potions[mid]*spell>=success){
               high=mid-1;
            }
            else{
              low=mid+1;
            }
        }
        return m-low;
    }
}