// No.733. Flood Fill
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        expand(image,sr,sc,newColor, visited, image[sr][sc]);
        return image;
    }
    
    private void expand(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int oldColor){
        if(image[sr][sc] != oldColor)return;
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        if(sr-1 >= 0 && !visited[sr-1][sc])
            expand(image,sr-1,sc,newColor, visited, oldColor);
        if(sr+1<image.length && ! visited[sr+1][sc])
            expand(image,sr+1,sc,newColor, visited, oldColor);
        if(sc-1 >= 0 && !visited[sr][sc-1])
            expand(image,sr,sc-1,newColor, visited, oldColor);
        if(sc+1<image[0].length && ! visited[sr][sc+1])
            expand(image,sr,sc+1,newColor, visited, oldColor);
    }
}
