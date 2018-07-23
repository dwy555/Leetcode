// No.542 01 Matrix

class Solution {
    
    public int[][] updateMatrix(int[][] matrix) {
        Deque<Integer> row_index = new LinkedList<>();
        Deque<Integer> col_index = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row_index.add(i);
                    col_index.add(j);
                    visited[i][j] = true;
                }
            }
        }
        int dis = 0;
        while(!row_index.isEmpty()){
            int size = row_index.size();
            for(int p = 0; p < size; p++){
                int row = row_index.poll(), col = col_index.poll();
                ans[row][col] = dis;
                if(row>0 && !visited[row-1][col]){
                    row_index.add(row-1);
                    col_index.add(col);
                    visited[row-1][col] = true;
                
                }
                if(row+1<m && !visited[row+1][col]){
                    row_index.add(row+1);
                    col_index.add(col);
                    visited[row+1][col] = true;
                }
                if(col>0 && !visited[row][col-1]){
                    row_index.add(row);
                    col_index.add(col-1);
                    visited[row][col-1] = true;
                
                }
                if(col+1<n && !visited[row][col+1]){
                    row_index.add(row);
                    col_index.add(col+1);
                    visited[row][col+1] = true;          
                }
            }
            dis++;    
        }
        return ans;
    }
}
