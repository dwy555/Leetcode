// No.636. Exclusive Time of Functions
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for(String str: logs){
            String[] strs = str.split(":");
            if(strs[1].equals("start")){
                if(!s.isEmpty())
                    ans[s.peek()] += Integer.parseInt(strs[2]) - prev;
                s.push(Integer.parseInt(strs[0]));
                prev = Integer.parseInt(strs[2]);
            }else{
                int index = s.pop();
                ans[index] += Integer.parseInt(strs[2])+1 - prev;
                prev = Integer.parseInt(strs[2])+1;
            }
        }
        return ans;
    }
}
