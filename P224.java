// No.224 Basic Calculator
class Solution {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        boolean isNum = false;
        int start = 0, end = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c <= '9' && c >='0'){
                if(!isNum){
                    isNum = true;
                    start = i;
                }
            }else{
                if(isNum){
                    isNum = false;
                    st.push(s.substring(start,i));
                }
                if(c == ' ')continue;
                if(c == '(' || c == '+' || c == '-')st.push(s.substring(i,i+1));
                else{
                    int sum = 0;
                    while(true){
                        int num = Integer.parseInt(st.pop());
                        String sign = st.pop();
                        if(sign.equals("(")){sum += num;break;}
                        if(sign.equals("+"))sum += num;
                        else sum -= num;
                    }
                    st.push(String.valueOf(sum));
                }
            }
        }
        if(isNum)st.push(s.substring(start));
        while(st.size() > 1){
            int num = Integer.parseInt(st.pop());
            String sign = st.pop();
            if(sign.equals("+"))ans += num;
            else ans -= num;
        }
        if(!st.isEmpty())ans += Integer.parseInt(st.pop());
        return ans;
    }
}
