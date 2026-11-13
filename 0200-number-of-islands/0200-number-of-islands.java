class Solution {
    public void bfs(int i,int j,boolean[][] visit,char[][] grid){
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        visit[i][j]=true;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.remove();
            for(int k=0;k<4;k++){
                int irow = row + dr[k];
                int icol = col + dc[k];
                if(irow>=0 && irow<n && icol>=0 && icol<m && grid[irow][icol]=='1' && !visit[irow][icol]){
                    visit[irow][icol]=true;
                    q.add(new int[]{irow,icol});

                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visit[i][j]){
                    bfs(i,j,visit,grid);
                    count++;
                }
            }
        }
        return count;
    }
}