// No.498 Diagonal Traverse
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)return new int[]{};
        int n = matrix[0].length;
        int dir = 1;
        int row = 0, col = 0;
        int i = 0,j = 0;
        int[] ans = new int[m*n];
        int index = 0;
        while(index < ans.length){
            if(dir == 1){
                for(; i >= 0 && j < n; i--,j++){
                    ans[index] = matrix[i][j];
                    index ++;
                }
                if(j < n)i++;
                else{j--; i += 2;}
                dir = 0;
            }else{
                for(; i < m&& j >= 0; i++, j--){
                    ans[index] = matrix[i][j];
                    index ++;
                }
                if(i < m)j++;
                else{i--;j += 2;}
                dir = 1;
            }
        }
        return ans;
    }
}
