class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[v];
        for(int [] arr : prerequisites){
            int x = arr[0];
            int y = arr[1];

            adj.get(x).add(y);
            indegree[y]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
           int p = q.poll();
           for(int u : adj.get(p)){
               indegree[u]--;
               if(indegree[u]==0){
                q.add(u);
               }
           }  
        }
        for(int i=0;i<v;i++){
            if(indegree[i]!=0){
                return false;
            }
        }
    return true;
    }
}
