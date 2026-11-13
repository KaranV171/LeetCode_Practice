class Solution {
    private void dfs(int row,int col, int[][] ans,int[][] image,int initCol,int color,int[] dr,int[] dc){
        int n = image.length;
        int m = image[0].length;
        ans[row][col]=color;
        for(int i=0;i<4;i++){
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==initCol && ans[nrow][ncol]!=color){
                dfs(nrow,ncol,ans,image,initCol,color,dr,dc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initCol = image[sr][sc];
        int[][] ans = image;
        int[] dr ={-1,1,0,0};
        int[] dc = {0,0,-1,1};
        dfs(sr,sc,ans,image,initCol,color,dr,dc);
        return ans;
    }
}