class Solution {
    public int smallestNumber(int n) {
        ArrayList<Integer>al = new ArrayList<>();
        int ele=n;
        while(true){
            int x=ele;
            while(x!=0){
                al.add(x%2);
                x=x/2;
            }
            int count=0;
            for(int i=0;i<al.size();i++){
                if(al.get(i)==1){
                    continue;
                }
                else{
                    count++;
                    ele++;
                    break;
                }
            }
            al.clear();
            if(count==0){
                break;
            }
            
        }
        return ele;
    }
}