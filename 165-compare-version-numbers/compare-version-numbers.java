class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        int val1=0;
        int val2=0;
        int len1=version1.length();
        int len2=version2.length();
        while(i<len1 || j<len2){
            val1=0;
            while(i<len1 && version1.charAt(i)!='.'){
                int num=version1.charAt(i)-'0';
                val1=val1*10+num;
                i++;
            }
            val2=0;
            while(j<len2 && version2.charAt(j)!='.'){
                int num=version2.charAt(j)-'0';
                val2=val2*10+num;
                j++;
           }
        
           if(val1>val2){
             return 1;
           }
           else if(val1<val2){
            return -1;
           }
           i++;
           j++;
        }
        return 0;
    }
}