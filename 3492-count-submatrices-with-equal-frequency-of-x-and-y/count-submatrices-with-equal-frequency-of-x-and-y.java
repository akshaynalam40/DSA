class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int freq1[][]=new int[m][n];
        int freq2[][]=new int[m][n];
        if(grid[0][0]=='X'){
            freq1[0][0]=1;
        }
        else{
            freq1[0][0]=0;
        }
        if(grid[0][0]=='Y'){
            freq2[0][0]=1;
        }
        else{
            freq2[0][0]=0;
        }
        for(int j=1;j<n;j++){
            if(grid[0][j]=='X'){
                freq1[0][j]=freq1[0][j-1]+1;
            }
            else{
                freq1[0][j]=freq1[0][j-1];
            }
            if(grid[0][j]=='Y'){
                freq2[0][j]=freq2[0][j-1]+1;
            }
            else{
                freq2[0][j]=freq2[0][j-1];
            }
        }
        for(int i=1;i<m;i++){
            if(grid[i][0]=='X'){
                freq1[i][0]=freq1[i-1][0]+1;
            }
            else{
                freq1[i][0]=freq1[i-1][0];
            }
            if(grid[i][0]=='Y'){
                freq2[i][0]=freq2[i-1][0]+1;
            }
            else{
                freq2[i][0]=freq2[i-1][0];
            }
        }
        int count=0;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]=='X'){
                    freq1[i][j]=freq1[i-1][j]+freq1[i][j-1]-freq1[i-1][j-1]+1;
                }
                else{
                    freq1[i][j]=freq1[i-1][j]+freq1[i][j-1]-freq1[i-1][j-1];
                }
                if(grid[i][j]=='Y'){
                    freq2[i][j]=freq2[i-1][j]+freq2[i][j-1]-freq2[i-1][j-1]+1;
                }
                else{
                    freq2[i][j]=freq2[i-1][j]+freq2[i][j-1]-freq2[i-1][j-1];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(freq1[i][j]==freq2[i][j] && freq1[i][j]>=1){
                    count++;
                }
            }
        }
       return count;
    }
}