// No.301. Remove Invalid Parentheses
class Solution {
    List<String> ans = new LinkedList<>();
    public List<String> removeInvalidParentheses(String s) {
        removePare(s,0,0,'(',')');
        return ans;
    }
    
    
    public void removePare(String s, int pos_i, int pos_j, char open, char close){
        for(int count = 0, i = pos_i; i < s.length(); i++){
            if(s.charAt(i) == open)count++;
            if(s.charAt(i) == close)count--;
            if(count >= 0)continue;
            for(int j = pos_j; j <= i; j++){
                if(s.charAt(j) == close && (j == pos_j || s.charAt(j-1) != close))
                    removePare(s.substring(0, j)+s.substring(j+1),i,j,open,close);
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(open == '(')
            removePare(reversed,0,0,close,open);
        else
            ans.add(reversed);
        
        
    } 
}
