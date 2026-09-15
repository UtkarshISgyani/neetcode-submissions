class Solution {
    public int dfs(int n, int m, int [][] grid , boolean [][] vis){
       vis[n][m]=true;
        int count=1;
       int [] movR = {-1 ,0 , 1, 0};
       int [] movC = {0 , 1 , 0, -1};
 
         int row = grid.length;
         int col = grid[0].length;

         for(int i =0 ;i<4;i++){
            int neighR = n + movR[i];
            int neighC = m + movC[i];
            if(neighR >= 0 && neighR < row && neighC >=0 && neighC < col && grid[neighR][neighC] == 1 && !vis[neighR][neighC]){
                count+=dfs(neighR, neighC, grid , vis);
             }
         }
       return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int area= 0;
       
        boolean [][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    int check = dfs(i,j,grid,vis);  
                    area  = Math.max(area , check);     
                }
            }
        }
    return area;
    }
}
