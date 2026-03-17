import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int arr[] = new int[n]; // this will act as height array
        int maxi = 0;

        for (int i = 0; i < m; i++) {

            // Step 1: build heights (FIXED)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    arr[j] += 1;
                } else {
                    arr[j] = 0;
                }
            }

            // Step 2: sort heights
            int temp[] = arr.clone();
            Arrays.sort(temp);

            // Step 3: calculate max area (FIXED LOGIC)
            for (int j = n - 1; j >= 0; j--) {
                int height = temp[j];
                int width = n - j;
                maxi = Math.max(maxi, height * width);
            }
        }

        return maxi;
    }
}