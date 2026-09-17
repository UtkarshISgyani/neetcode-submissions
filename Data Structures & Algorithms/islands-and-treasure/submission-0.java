class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }
        
        int count = 1;
        int[] movR = {-1, 0, 1, 0};
        int[] movC = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int k = q.size();
            for (int j = 0; j < k; j++) {
                Pair p = q.poll();
                int x = p.i;
                int y = p.j;
                
                for (int i = 0; i < 4; i++) {
                    int newR = x + movR[i];
                    int newC = y + movC[i];
                    if (newR >= 0 && newR < n && newC >= 0 && newC < m && !vis[newR][newC]
                        && grid[newR][newC] != -1) {
                        vis[newR][newC] = true;
                        grid[newR][newC] = count;
                        q.add(new Pair(newR, newC));
                    }
                }
               
            }
             count++;
        }
    }
}
