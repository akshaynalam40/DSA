class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int ans[][] = new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++) {
                HashSet<Integer> set = new HashSet<>();
                for(int x =i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        set.add(grid[x][y]);
                    }
                }
                List<Integer>al = new ArrayList<>(set);
                Collections.sort(al);
                int min=Integer.MAX_VALUE;
                if(al.size()<=1){
                    min=0;
                }
                 else{
                    for(int z=1;z<al.size();z++){
                        min = Math.min(min,al.get(z)-al.get(z-1));
                    }
                }
                ans[i][j]=min;
            }
        }
        return ans;
    }
}