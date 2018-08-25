// No.20. Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{')st.push(c);
            else{
                if(st.isEmpty())return false;
                char a = st.pop();
                if(c == ')' && a != '(')return false;
                if(c == ']' && a != '[')return false;
                if(c == '}' && a != '{')return false;
            }
        }
        return st.isEmpty();
    }
}
