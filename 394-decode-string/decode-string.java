class Solution {
    public boolean isdigit(char ch){
        if(ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
    public String decodeString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int num=0;
        for(int i = 0;i<n;i++){
            if(isdigit(s.charAt(i))){
                num=num * 10 + (s.charAt(i) - '0');  
            }
            else if(s.charAt(i) == '['){
                stack.push(num);
                num = 0;
                st.push('[');
            }
            else if(s.charAt(i)==']'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='['){
                    sb.append(st.pop());
                }
                st.pop();
                sb.reverse();
                String res = sb.toString();
                int last = 0;
                if(!stack.isEmpty()){
                    last = stack.pop();
                }
                int count = 0;
                String ans = "";
                while(count < last){
                    ans = ans + res;
                    count++;
                }
                for(int j = 0; j < ans.length(); j++){
                    st.push(ans.charAt(j));
                }

            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder finalval = new StringBuilder();
        while(!st.isEmpty()){
            finalval.append(st.pop());
        }
        return finalval.reverse().toString();
    }
}