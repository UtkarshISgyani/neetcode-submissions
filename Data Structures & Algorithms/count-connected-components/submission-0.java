class Solution {
    public int countComponents(int n, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] arr : edges){
            int x = arr[0];
            int y = arr[1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        int count=0;
        boolean [] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(adj,vis,i);
                count++;
            }
        }
        return count;
    }
    public void bfs(ArrayList<ArrayList<Integer>> adj ,boolean [] vis, int u){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        vis[u]=true;
        while(!q.isEmpty()){
           int p = q.poll();
           for(int v : adj.get(p)){
              if(!vis[v]){
                q.add(v);
                vis[v] = true;
              }
           }  
        }
    }
}
