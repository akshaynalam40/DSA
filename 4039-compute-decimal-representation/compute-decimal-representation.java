class Solution {
    public int[] decimalRepresentation(int n) {
        int x=n;
        int power=0;
        ArrayList<Integer>al= new ArrayList<>();
        while(x>0){
            int id=x%10;
            int  ans=id*(int)(Math.pow(10,power));
            if(ans!=0){
            al.add(ans);
            }
            power++;
            x=x/10;
        }
        Collections.sort(al);
        int arr[]=new int[al.size()];
        int j=0;
        for(int i=al.size()-1;i>=0;i--){
            arr[j++]=al.get(i);
        }
        return arr;
    }
}