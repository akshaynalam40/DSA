class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int mat[][]= new int[n][n];
        int len=queries.length;
        for(int i=0;i<len;i++){
            int startrow=queries[i][0];
            int startcol=queries[i][1];
            int endrow=queries[i][2];
            int endcol=queries[i][3];
            for(int k=startrow;k<=endrow;k++){
                for(int j=startcol;j<=endcol;j++){
                    mat[k][j]=mat[k][j]+1;
                }
            }
        }
        return mat;
    }
}