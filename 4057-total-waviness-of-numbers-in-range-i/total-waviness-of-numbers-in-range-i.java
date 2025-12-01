class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++) {
            ArrayList<Integer> al = new ArrayList<>();
            int x=i;
            while(x!=0) {
                al.add(0, x % 10);
                x/=10;
            }
            if(al.size()<3){
                continue;
            }
            for(int j=1;j<al.size()-1;j++) {
                int left=al.get(j - 1);
                int mid=al.get(j);
                int right=al.get(j + 1);
                if((mid>left&&mid>right)||(mid<left&&mid<right)) {
                    count++;
                }
            }
        }

        return count;
    }
}
