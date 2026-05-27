import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {

        HashMap<Character, Integer> lastSmall = new HashMap<>();
        HashMap<Character, Integer> firstCapital = new HashMap<>();

        int n = word.length();

        for (int i = 0; i < n; i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {

                lastSmall.put(ch, i);

            } else {

                firstCapital.putIfAbsent(ch, i);
            }
        }

        int count = 0;

        for (char ch : lastSmall.keySet()) {

            char big = (char)(ch - 'a' + 'A');

            if (firstCapital.containsKey(big)) {

                if (lastSmall.get(ch) < firstCapital.get(big)) {
                    count++;
                }
            }
        }

        return count;
    }
}