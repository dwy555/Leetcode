// No.240 Search a 2D Matrix II
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)return false;
        int n = matrix[0].length;
        int row = m-1, col = 0;
        while(row >=0 && col < n){
            if(matrix[row][col] == target)return true;
            if(matrix[row][col] < target)
                col++;
            else
                row--;
        }
        return false;
    }
}
