import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] freq = new boolean[nums.length];
        per(nums, freq, new ArrayList<>());
        return res;
    }

    public void per(int[] nums, boolean[] freq, List<Integer> al) {
        if (al.size() == nums.length) {
            res.add(new ArrayList<>(al));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (freq[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !freq[i - 1]) continue;

            freq[i] = true;
            al.add(nums[i]);
            per(nums, freq, al);
            al.remove(al.size() - 1);
            freq[i] = false;
        }
    }
}
