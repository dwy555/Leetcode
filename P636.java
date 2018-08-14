// No.636. Exclusive Time of Functions
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String str: logs){
            String[] strs = str.split(":");
            if(strs[1].equals("start")){
                if(!st.isEmpty())
                    ans[st.peek()] += Integer.parseInt(strs[2]) - prev;
                st.push(Integer.parseInt(strs[0]));
                prev = Integer.parseInt(strs[2]);
            }else{
                int index = st.pop();
                ans[index] += Integer.parseInt(strs[2])+1 - prev;
                prev = Integer.parseInt(strs[2])+1;
            }
        }
        return ans;
    }
}
