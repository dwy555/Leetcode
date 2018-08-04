// No.241 Different Ways to Add Parentheses
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> part1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i+1));
                for(Integer num1: part1){
                    for(Integer num2: part2){
                        int res = 0;
                        if(input.charAt(i) == '+')res = num1 + num2;
                        else if(input.charAt(i) == '-')res = num1 - num2;
                        else res = num1 * num2;
                        ans.add(res);
                    }
                }
            }
        }
        if(ans.size() == 0)ans.add(Integer.valueOf(input));
        return ans;
        
    }    

}
