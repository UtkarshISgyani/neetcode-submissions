class Solution {
    public void dfs(int[][] heights,boolean [][] vis , int u ,int v){
        vis[u][v] = true;
        int[] movR = {-1, 0, 1, 0};
        int[] movC = {0, 1, 0, -1};
        int n =heights.length;
        int m = heights[0].length;
        for(int i=0;i<4;i++){
            int newR = u + movR[i];
            int newC = v + movC[i];
            if(newR >= 0 && newR < n && newC >= 0 && newC < m && !vis[newR][newC] && heights[newR][newC]>=heights[u][v]){
                dfs(heights , vis , newR , newC);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int n =heights.length;
        int m = heights[0].length;
        boolean [][] vis1 = new boolean[n][m];
        boolean [][] vis2 = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    vis1[i][j]=true;
                }
                if(i==n-1 || j==m-1){
                    vis2[i][j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis1[i][j]){
                    dfs(heights , vis1 , i , j);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(vis2[i][j]){
                    dfs(heights , vis2 , i , j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis1[i][j] && vis2[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
            
        }
        
        return list;
    }
}
