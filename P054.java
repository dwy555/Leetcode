// No.54 Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)return list;
        int n = matrix[0].length;
        cycle(list, 0, m, 0, n, matrix);
        
        return list;
    }
    
    public void cycle(List<Integer> list, int m1, int m2, int n1, int n2, int[][]matrix){
        if(m1 >= m2 || n1 >= n2)
            return;
        int i, j;
        for(i = m1, j = n1; j < n2; j ++ )
            list.add(matrix[i][j]);
        for(i = m1+1, j = n2-1; i < m2; i ++)
            list.add(matrix[i][j]);
        for(i = m2-1, j = n2-2; i > m1 && j > n1-1; j--)
            list.add(matrix[i][j]);
        for(i = m2-2, j = n1; i > m1 && j < n2-1; i--)
            list.add(matrix[i][j]);
        cycle(list, m1+1, m2-1, n1+1, n2-1, matrix);
    }
}
