class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] visited = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source]=1;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==destination) return true;
            for(int next : adj.get(curr)){
                if(visited[next]==0){
                    q.add(next);
                    visited[next]=1;
                }
            }
        }
        return false;
    }
}