import java.util.*;

class Solution {

    public String recur(String s, int i, HashSet<String> hs) {

        if(i == s.length()){
            if(!hs.contains(s)){
                return s;
            }
            return "";
        }

        char[] arr = s.toCharArray();

        arr[i] = '0';
        String res = recur(new String(arr), i+1, hs);
        if(!res.equals("")) return res;

        arr[i] = '1';
        return recur(new String(arr), i+1, hs);
    }

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        HashSet<String> hs = new HashSet<>();

        for(String num : nums){
            hs.add(num);
        }

        String s = "";
        for(int i=0;i<n;i++){
            s = s + '0';
        }

        return recur(s,0,hs);
    }
}