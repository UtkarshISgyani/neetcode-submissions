class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0 ;i<v;i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[v];
        for(int [] arr : prerequisites){
            int x = arr[0];
            int y = arr[1];

            adj.get(y).add(x);
            indegree[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int [] ans = new int[v];
        int k=0;
        while(!q.isEmpty()){
           int p = q.poll();
           ans[k++]=p;
           for(int u : adj.get(p)){
               indegree[u]--;
               if(indegree[u]==0){
                q.add(u);
               }
           }  
          
        }
        for(int i=0;i<v;i++){
            if(indegree[i]!=0){
                return new int[]{};
            }
        }
    return ans;
    }
}
