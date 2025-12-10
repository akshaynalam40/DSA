class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        long ans=1;
        int min=complexity[0];
        for(int i=1;i<n;i++){
            if(min>=complexity[i]){
                return 0;
            }
        }
        for(int i=1;i<n;i++){
            ans=(ans*i)%1_000_000_007;
        }
        return (int)ans;
    }
}