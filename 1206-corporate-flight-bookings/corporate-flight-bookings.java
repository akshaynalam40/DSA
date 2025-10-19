class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int len=bookings.length;
        int ans[]=new int[n+1];
        for(int i=0;i<len;i++){
          int start=bookings[i][0];
          int end=bookings[i][1];
          int seats=bookings[i][2];
          ans[start-1]=ans[start-1]+seats;
          if(end<n){
            ans[end]=ans[end]-seats;
          }
        }
       int res[]= new int[n];
       res[0]=ans[0];
       for(int i=1;i<n;i++){
        res[i]=res[i-1]+ans[i];
       } 
     return res;
        
    }
}