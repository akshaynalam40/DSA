class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // arr[i] = {value, digitSum, originalIndex}
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            int x = nums[i], sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            arr[i][0] = nums[i];
            arr[i][1] = sum;
            arr[i][2] = i;
        }

        // Sort by digit sum, then value
        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][2] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][2];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }
}
