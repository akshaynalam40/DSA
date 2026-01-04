class Solution {
    public List<List<String>> wordSquares(String[] words) {
    int n=words.length;
    Arrays.sort(words);
    List<List<String>>res=new ArrayList<>();
    HashSet<String>hs= new HashSet<>();
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            for(int m=0;m<n;m++){
                for(int l=0;l<n;l++){
                    if(i==j || i==m || i==l || j==m || j==l || m==l){
                        continue;
                    }
                    String top=words[i];
                    String left=words[j];
                    String right=words[m];
                    String bottom=words[l];
                    if(top.charAt(0)==left.charAt(0)&&
                       top.charAt(3)==right.charAt(0)&&
                       bottom.charAt(0)==left.charAt(3) &&
                       bottom.charAt(3)==right.charAt(3)){
                        List<String>new1=new ArrayList<>();
                        new1.add(top);
                        new1.add(left);
                        new1.add(right);
                        new1.add(bottom);
                        String check=String.join(" ,",new1);
                         if(!hs.contains(check)){
                            res.add(new1);
                         }
                       }
                }

            }
        }
    }
    return res;
    }
}