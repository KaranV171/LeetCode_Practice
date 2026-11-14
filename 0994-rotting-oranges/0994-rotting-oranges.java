class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dr={-1,1,0,0};
        int[] dc = {0,0,-1,1};
        Queue<int[]> q = new LinkedList<>();
        int[][] visit = new int[n][m];
        int originalFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                    visit[i][j]=2;
                }else{
                    visit[i][j]=0;
                }

                if(grid[i][j]==1){
                    originalFresh++;
                }
            }
        }
        int t =0;
        int count = 0;
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int time = q.peek()[2];
            visit[row][col]=2;
            t = Math.max(t,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && visit[nrow][ncol]!=2){
                    count++;
                    q.add(new int[]{nrow,ncol,time+1});
                    visit[nrow][ncol]=2;
                }
            }
        }
        if(originalFresh!=count) return -1;

        return t;
    }
}