class Solution {
    public void dfs(char[][] board , boolean [][] vis , int u ,int v){
        vis[u][v] = true;
        int[] movR = {-1, 0, 1, 0};
        int[] movC = {0, 1, 0, -1};
         int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++){
            int newR = u + movR[i];
            int newC = v + movC[i];
            if(newR >= 0 && newR < n && newC >= 0 && newC < m && !vis[newR][newC] && board[newR][newC]=='O'){
                dfs(board , vis , newR , newC);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !vis[i][0]){
                dfs(board , vis , i ,0);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                dfs(board , vis , i ,m-1);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(board , vis , 0 ,i);
            }
            if(board[n-1][i]=='O' && !vis[n-1][i]){
                dfs(board , vis , n-1 ,i);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
