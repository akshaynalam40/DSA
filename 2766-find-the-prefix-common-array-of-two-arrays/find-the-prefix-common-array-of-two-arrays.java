class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] ans=new int[n];
        HashSet<Integer>setA=new HashSet<>();
        HashSet<Integer>setB=new HashSet<>();
        int common=0;
        for(int i=0;i<n;i++){
            if(setB.contains(A[i])){
                common++;
            }
            if(setA.contains(B[i])){
                common++;
            }
            if(A[i]==B[i]) {
                common++;
            }
            setA.add(A[i]);
            setB.add(B[i]);
            ans[i] = common;
        }
        return ans;
    }
}