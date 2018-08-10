// No.150. Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String str = tokens[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int num1 = Integer.parseInt(st.pop());
                int num2 = Integer.parseInt(st.pop());
                if(str.equals("+"))st.push(String.valueOf(num1 + num2));
                else if(str.equals("-"))st.push(String.valueOf(num2 - num1));
                else if(str.equals("*"))st.push(String.valueOf(num1 * num2));
                if(str.equals("/"))st.push(String.valueOf(num2 / num1));
            }else{
                st.push(str);
            }
        }
        return Integer.parseInt(st.pop());
    }
}
