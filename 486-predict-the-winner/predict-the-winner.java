class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int player1=0;
        int player2=0;
        boolean ans=findrecur(nums,0,n-1,player1,player2,true);
        return ans;
        
    }
    public boolean findrecur(int nums[],int i, int j,int player1,int player2,boolean turn){
        if(i>j){
            if(player1>=player2){
                 return true;
            }
            return false;
        }
        if(turn){
          boolean first= findrecur(nums,i+1,j,player1+nums[i],player2,false);
          boolean second= findrecur(nums,i,j-1,player1+nums[j],player2,false);
          return first||second;
        }
        else{

           boolean third=findrecur(nums,i+1,j,player1,player2+nums[i],true);
           boolean fourth=findrecur(nums,i,j-1,player1,player2+nums[j],true);
           return third && fourth;
        }

    }
}