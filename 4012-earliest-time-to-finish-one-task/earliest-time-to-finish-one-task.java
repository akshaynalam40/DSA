class Solution {
    public int earliestTime(int[][] tasks) {
        int m=tasks.length;
        int min=32767;
        for(int i=0;i<m;i++){
         int s=tasks[i][0];
         int t=tasks[i][1];
         int ans=s+t;
         min=Math.min(ans,min);
        }
        return min;
    }
}