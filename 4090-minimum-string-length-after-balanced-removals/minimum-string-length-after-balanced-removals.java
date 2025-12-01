class Solution {
    public int minLengthAfterRemovals(String s) {
        int count=0;
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        Stack<Character>st= new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='a'){
                st.push('a');
            }
            else{
                if(!st.isEmpty()){
                st.pop();
                count++;
                }
            }
        }
        return s.length()-2*count;
    }
}