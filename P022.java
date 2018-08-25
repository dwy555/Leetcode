// No.22. Generate Parentheses
class Solution {
    List<String> ans = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        genPare(0,0,"",n);
        return ans;
    }
    
    public void genPare(int open, int close, String str, int n){
        if(str.length() == n*2){
            ans.add(str);
            return;
        }
        if(open < n){
            genPare(open+1, close, str+"(", n);
        }
        if(close < open){
            genPare(open, close+1, str+")", n);
        }
    }
}
