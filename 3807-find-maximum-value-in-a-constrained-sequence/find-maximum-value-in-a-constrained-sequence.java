class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
       int maxPossible[] = new int[n];
        maxPossible[0] = 0;
        for(int i = 1; i < n; i++){
            maxPossible[i] = maxPossible[i - 1] + diff[i - 1];
        }

        for(int[] l: restrictions){
            int idx = l[0];
            int maxVal = l[1];
            maxPossible[idx] = Math.min(maxPossible[idx], maxVal);
        }

        for(int i = 1; i < n; i++) {
            maxPossible[i] = Math.min(
                maxPossible[i],
                maxPossible[i - 1] + diff[i - 1]
            );
        }

        for(int i = n - 2; i >= 0; i--) {
            maxPossible[i] = Math.min(
                maxPossible[i],
                maxPossible[i + 1] + diff[i]
            );
        }

        int ans = 0;
        for(int val : maxPossible){
            ans = Math.max(ans, val);
        }

        return ans;

    }
}