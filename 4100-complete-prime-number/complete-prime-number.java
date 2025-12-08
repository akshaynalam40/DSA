class Solution {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public boolean completePrime(int num) {

        int x = num;
        int y = num;
        int z = num;

        // count digits
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }

        int pre[] = new int[count];      // size = count
        int suff[] = new int[count];

        // --------------------
        // Build prefix array
        // --------------------
        pre[0] = num;
        int p = num;

        for (int i = 1; i < count; i++) {
            p = p / 10;        // remove last digit
            pre[i] = p;
        }

        // --------------------
        // Build suffix array
        // --------------------
        int divisor = 10;

        for (int i = 0; i < count; i++) {
            suff[i] = num % divisor;
            divisor *= 10;
        }

        // --------------------
        // Check all prefixes
        // --------------------
        for (int l = 0; l < pre.length; l++) {
            if (!isPrime(pre[l])) {
                return false;
            }
        }

        // --------------------
        // Check all suffixes
        // --------------------
        for (int r = 0; r < suff.length; r++) {
            if (!isPrime(suff[r])) {
                return false;
            }
        }

        return true;
    }
}
