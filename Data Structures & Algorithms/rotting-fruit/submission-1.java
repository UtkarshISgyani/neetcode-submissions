class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }
        int[] movR = {-1, 0, 1, 0};
        int[] movC = {0, 1, 0, -1};
        int count = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            for (int j = 0; j < k; j++) {
                Pair p = q.poll();
                int x = p.i;
                int y = p.j;

                for (int i = 0; i < 4; i++) {
                    int newR = x + movR[i];
                    int newC = y + movC[i];
                    if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        q.add(new Pair(newR, newC));
                    }
                }
            }
            if(!q.isEmpty()){
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
