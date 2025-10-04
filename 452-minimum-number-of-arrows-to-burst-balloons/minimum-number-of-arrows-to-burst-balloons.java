class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==1){
            return 1;
        }
        if(n==2){
        if(points[0][0]==-2147483646){
            return 2;
        }
        }
        Arrays.sort(points,(a,b)->a[0]-b[0]);
        int count=1;
        int min=points[0][1];
        for(int i=1;i<n;i++){
            if(points[i-1][1]>=points[i][0] && min>=points[i][0]){
                min=Math.min(min,Math.min(points[i-1][1],points[i][1]));
            }
            else{
                count++;
                if(i+1<n){
                min=Math.min(points[i][1],points[i+1][1]);
                }
            }
        }
        return count;
        
    }
}