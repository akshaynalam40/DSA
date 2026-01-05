class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int arr[] = new int[n * n];
        int k = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    count++;
                }
                arr[k++] = Math.abs(matrix[i][j]);
            }
        }

        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (count % 2 != 0) {
            sum -= 2L * arr[0];
        }

        return sum;
    }
}
