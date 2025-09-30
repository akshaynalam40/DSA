class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int maxi=0;
        if(n==2){
            int min=Math.min(height[0],height[1]);
            return min;
        }
        int min=Math.min(height[i],height[j]);
        maxi=Math.max(maxi,min*j-i);
        while(i<j){
            if(height[i]<height[j]){
                i++;
            }
            else if(height[i]>height[j]){
                j--;
            }
            else{
                maxi=Math.max(maxi,height[i]*(j-i));
                i++;
                j--;
                
            }
             min=Math.min(height[i],height[j]);
            maxi=Math.max(maxi,min*(j-i));
        }
        return maxi;
    }
}