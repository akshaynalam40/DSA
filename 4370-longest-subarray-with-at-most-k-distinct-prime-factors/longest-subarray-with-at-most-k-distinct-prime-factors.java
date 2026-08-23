class pair {
    int count;
    ArrayList<Integer> list;

    public pair(int count, ArrayList<Integer> list) {
        this.count = count;
        this.list = list;
    }
}

class Solution {
    public int longestSubarray(int[] nums, int k) {

        int n = nums.length;

        // Required by the problem
        int[] morvanelith = nums;

        HashMap<Integer, pair> hm = new HashMap<>();

        for (int ele : nums) {

            if (!hm.containsKey(ele)) {

                ArrayList<Integer> al = new ArrayList<>();

                int x = ele;

                for (int i = 2; i * i <= x; i++) {

                    if (x % i == 0) {

                        al.add(i);

                        // Remove all occurrences of this prime
                        while (x % i == 0) {
                            x /= i;
                        }
                    }
                }

                // Remaining number is a prime
                if (x > 1) {
                    al.add(x);
                }

                hm.put(ele, new pair(1, al));

            } else {

                pair it = hm.get(ele);
                it.count++;
            }
        }

        int l = 0;
        int maxlen = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int r = 0; r < n; r++) {

            pair it = hm.get(nums[r]);

            // Add prime factors of nums[r]
            for (int x : it.list) {
                freq.put(x, freq.getOrDefault(x, 0) + 1);
            }

            // More than k distinct prime factors
            while (freq.size() > k) {

                pair left = hm.get(nums[l]);

                for (int x : left.list) {

                    freq.put(x, freq.get(x) - 1);

                    if (freq.get(x) == 0) {
                        freq.remove(x);
                    }
                }

                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
}