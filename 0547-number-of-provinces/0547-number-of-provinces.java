class Solution {

    private void dfs(int node,boolean[] visit,ArrayList<ArrayList<Integer>> adj){
        visit[node]=true;
        for(int next : adj.get(node)){
            if(!visit[next]){
                dfs(next,visit,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visit = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                count++;
                dfs(i,visit,adj);
            }
        }
        return count;
    }
}