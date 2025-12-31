class Solution {

    public void dfs(int[][] image, int sr, int sc, int initialColor, int newColor, int[] drow, int[] dcol){
        image[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i<4; i++){
            int nrow = sr+drow[i];
            int ncol = sc+dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor){
                dfs(image, nrow, ncol, initialColor, newColor, drow, dcol);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        if(image[sr][sc] != color){
            dfs(image, sr, sc, image[sr][sc], color, drow, dcol);
        }
        return image;
    }
}
