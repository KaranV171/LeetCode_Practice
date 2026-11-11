class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        
        for(int i=0;i<n;i++){
            if(colors[i]!=0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i]=1;

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int next : graph[curr]){
                    if(colors[next]==0){
                        colors[next] = -colors[curr];
                        q.offer(next);
                    }else if(colors[next]!=-colors[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}