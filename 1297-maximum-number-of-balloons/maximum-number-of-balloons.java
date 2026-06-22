class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(text.charAt(i), hm.getOrDefault(text.charAt(i), 0) + 1);
        }

        int count = Integer.MAX_VALUE;
        String check = "balloon";

        for (int i = 0; i < check.length(); i++) {
            char ch = check.charAt(i);

            if (!hm.containsKey(ch)) {
                return 0;
            }

            if (ch == 'l' || ch == 'o') {
                count = Math.min(count, hm.get(ch) / 2);
            } else {
                count = Math.min(count, hm.get(ch));
            }
        }

        return count;
    }
}