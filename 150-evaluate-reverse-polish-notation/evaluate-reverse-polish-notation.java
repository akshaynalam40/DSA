class Solution {
    public boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i<n;i++){
            if(isOperator(tokens[i])){
                int a = st.pop();
                int b = st.pop();
                int val = 0;
                if(tokens[i].equals("+"))
                {
                    val=b+a;
                }
                else if(tokens[i].equals("-"))
                {
                    val=b-a;
                }
                else if(tokens[i].equals("*"))
                {
                    val =b*a;
                }
                else{
                    val=b/a;
                }
                st.push(val);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}