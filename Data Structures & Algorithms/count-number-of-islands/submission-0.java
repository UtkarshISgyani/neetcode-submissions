class Solution {
    public void dfs(char[][] grid,boolean [][] vis,int u,int v){
         vis[u][v] = true;
         
         int [] movR = {-1,0,1,0};
         int [] movC = {0,1,0,-1};

         int row = grid.length;
         int col = grid[0].length;

         for(int i=0;i<4;i++){
            int newR = u + movR[i];
            int newC = v + movC[i];

            if(newR >= 0 && newR <row && newC >=0 && newC < col && grid[newR][newC]=='1' &&  vis[newR][newC]==false){
                dfs(grid , vis , newR ,newC);
            }
         }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int count=0;
        boolean [][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                     count++;
                     dfs(grid , vis , i,j);
                }
            }
        }
        return count;
    }
}
