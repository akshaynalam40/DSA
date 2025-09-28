class Solution {
    public String majorityFrequencyGroup(String s) {
        int len = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i=0;i<len;i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Map.Entry<Character,Integer> entry : hm.entrySet()) {
            int key = entry.getValue();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int maxi = -1;
        int maxiele = -1;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxi ||(entry.getValue() == maxi && entry.getKey() > maxiele)) { 
                maxi = entry.getValue();
                maxiele = entry.getKey();
            }
        }
        StringBuilder res = new StringBuilder();
        for (char key : hm.keySet()) {
            if (hm.get(key) == maxiele) {
                res.append(key);
            }
        }
        return res.toString();
    }
}
