class Solution {
    public int smallestNumber(int n) {
        int ele = n;
        while (true) {
            int x = ele;
            boolean allOnes = true;
            while (x != 0) {
                if (x % 2!= 1) {
                    allOnes = false;
                    break;
                }
                x = x /2;
            }
            if (allOnes) {
                return ele;
            }
            ele++;
        }
    }
}
