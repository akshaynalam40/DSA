class Solution {
    public int minCost(int n) {
        if(n==1){
            return 0;
        }
        int mincost=0;
        ArrayList<Integer>al=new ArrayList<>();
        int val=n;
        al.add(val);
        while(al.size()!=0){
            int first=1;
            int end=val-1;
            mincost+=first*end;
            al.remove(al.size()-1);
            val=end;
            if(val==1){
                break;
            }
            al.add(val);
        }
      return mincost;
    }
}