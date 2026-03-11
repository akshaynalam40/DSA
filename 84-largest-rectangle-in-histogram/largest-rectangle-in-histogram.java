class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer>st=new Stack<>();
        int pse[]= new int[n];
        pse[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        int nge[]=new int[n];
        nge[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        int maxi=0;
        for(int i=0;i<n;i++){
            int width=nge[i]-pse[i]-1;
            int area=heights[i]*width;
           maxi=Math.max(area,maxi);
        }
        return maxi;
    }
}