class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int i=0,j=1;
        int count=1;
        while(j<n){
         if(pairs[i][1]<pairs[j][0]){
            count++;
            i=j;
            j=i+1;
         }
         else{
            j++;
         }
        }
        return count;
        
    }
}