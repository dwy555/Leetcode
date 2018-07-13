// No.463 Island Perimeter
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        int lap = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1)num++;
                if(j != n-1)
                    if(grid[i][j]*grid[i][j+1] == 1)lap++;
                if(i != m-1)
                    if(grid[i][j]*grid[i+1][j] == 1)lap++;
                
            }
        }
        int peri = num*4 - lap*2;
        return peri;
    }
}
