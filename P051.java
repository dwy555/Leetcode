// No.51 N-Queens
class Solution {
    
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> diag1s = new HashSet<Integer>();
    Set<Integer> diag2s = new HashSet<Integer>();

    List<List<String>> ans = new LinkedList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[][] map = new int[n][n];
        findSolution(map, n, 0);
        return ans;
    }
    
    public void findSolution(int[][] map, int n, int row){
        for(int col=0;col<n;col++){
            if(cols.contains(col))
                continue;
            int diag1 = row+col;
            if(diag1s.contains(diag1))
                continue;
            int diag2 = row-col;
            if(diag2s.contains(diag2))
                continue;
            if(row==n-1){
                map[row][col] = 1;
                addToList(map,n);
                map[row][col] = 0;
            }else{
                cols.add(col);
                diag1s.add(diag1);
                diag2s.add(diag2);
                map[row][col] = 1;
                findSolution(map,n,row+1);
                map[row][col] = 0;
                cols.remove(col);
                diag1s.remove(diag1);
                diag2s.remove(diag2);
            }
        }
    }
    
    public void addToList(int[][] map, int n){
        List<String> list = new LinkedList<String>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                if(map[i][j]==0){
                    sb.append(".");
                }else{
                    sb.append("Q");
                }
            }
            list.add(sb.toString());
        }
        ans.add(list);
    }
}
