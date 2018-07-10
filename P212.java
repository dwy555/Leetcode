// No.212 Word Search II
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> list = new LinkedList<String>();
        for(String str: words){
            if(!list.contains(str) && exist(board,str))
                list.add(str);
        }
        return list;
        
        
    }
    
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && search(i,j, visited, board, word, 0))
                    return true;
            }
        }
        return false;       
    }
    
    
    public boolean search(int i, int j, int[][] visited, char[][] board, String word, int index){
        if(index == word.length())return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]==1 || board[i][j] != word.charAt(index))
            return false;
        
        visited[i][j] = 1;
        if(search(i+1,j,visited, board, word, index+1) ||
          search(i-1,j,visited, board, word, index+1) ||
          search(i,j+1,visited, board, word, index+1) ||
          search(i,j-1,visited, board, word, index+1))
            return true;
        visited[i][j] = 0;
        return false;
        
    }
    
}
