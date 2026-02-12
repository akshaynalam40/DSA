import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int max=0;
        for (int i = 0;i < n;i++) {
            int arr[]= new int[26];
            for (int j=i;j < n;j++) {
                arr[s.charAt(j)-'a']++;
                if (isBal(arr)) {
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    private boolean isBal(int[] arr) {
        int flag = 0;
        for (int a: arr) {
            if (a> 0) {
                if(flag== 0){
                    flag=a;
                }
                else if(a!=flag){
                    return false;
                }
            }
        }
        return true;
    }
}