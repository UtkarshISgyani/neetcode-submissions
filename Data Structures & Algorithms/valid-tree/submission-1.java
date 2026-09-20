class Pair{
    int parent;
    int u;
    Pair(int parent , int  u){
        this.parent = parent;
        this.u = u;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        boolean [] vis = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(-1 , 0));
        while(!q.isEmpty()){
           Pair p = q.poll();
           int parent = p.parent;
           int u = p.u;
           vis[u] = true;
           for(int v : adj.get(u)){
               if(vis[v]!=true){
                 q.add(new Pair(u , v));
                 vis[v]=true;
               }
               else if(vis[v]==true && v!=parent){
                   return false;
               }
           }  
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                return false;
            }
        }
    return true;
    }
}
