class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer>al= new ArrayList<>();
        String s="123456789";
        String l=String.valueOf(low);
        String h=String.valueOf(high);
        int len=l.length();
        for(int i=len;i<=h.length();i++){
            for(int j=0;j<=9-i;j++){
                int num=Integer.parseInt(s.substring(j,j+i));
                if(num>=low && num<=high){
                    al.add(num);
                }
            }

        }

       return al;
    }
}