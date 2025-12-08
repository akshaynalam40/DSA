import java.util.*;

class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int n = technique1.length;
        long total = 0;

        // Step 1: Compute signed difference (tech1 - tech2)
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = technique1[i] - technique2[i];
        }

        // Step 2: Put index -> difference in hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(i, diff[i]);
        }

        // Step 3: Convert to list and sort by value ascending
        List<Map.Entry<Integer, Integer>> al = new ArrayList<>(hm.entrySet());
        al.sort(Map.Entry.comparingByValue());

        // Step 4: Pick last k tasks (highest difference) → Technique 1
        for (int i = n - k; i < n; i++) {
            int index = al.get(i).getKey();
            total += technique1[index];
            technique1[index] = 0;
            technique2[index] = 0;
        }

        // Step 5: For remaining tasks, pick max of technique1 or technique2
        for (int i = 0; i < n; i++) {
            total += Math.max(technique1[i], technique2[i]);
        }

        return total;
    }
}
