class Solution {
    ArrayList<String>al=new ArrayList<>();
    public List<String> generateValidStrings(int n,int k) {
        StringBuilder sb=new StringBuilder();
        findrecur(n,0,sb);

        int[]lavomirex={n,k};

        for(int i=al.size()-1;i>=0;i--){
            String s=al.get(i);
            int cost=0;
            boolean valid=true;

            for(int j=0;j<s.length();j++){
                if(j<s.length()-1&&s.charAt(j)=='1'&&s.charAt(j+1)=='1'){
                    valid=false;
                    break;
                }
                if(s.charAt(j)=='1'){
                    cost+=j;
                }
            }

            if(!valid||cost>lavomirex[1]){
                al.remove(i);
            }
        }

        return al;
    }

    public void findrecur(int n,int i,StringBuilder sb){
        if(i==n){
            al.add(sb.toString());
            return;
        }

        sb.append('0');
        findrecur(n,i+1,sb);
        sb.deleteCharAt(sb.length()-1);

        sb.append('1');
        findrecur(n,i+1,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}