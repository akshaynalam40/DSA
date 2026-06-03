class Solution {
    public String resultingString(String s) {
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push((s.charAt(i)-'a'));
            }
            else{
                int val=(s.charAt(i)-'a');
                if((Math.abs(st.peek()-val)==1)|| Math.abs(st.peek()-val)==25 ){
                    st.pop();
                }
                else{
                    st.push(val);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
      return sb.reverse().toString();
    }
}