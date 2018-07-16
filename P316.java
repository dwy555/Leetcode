// No.316 Remove Duplicate Letters
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        for(char c : arr)
            count[c-'a']++;
       
        for(char c : arr) {
            count[c-'a']--;
            if(visited[c-'a'])continue;
            while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0) {
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        for(char c : stack)
            sb.append(c);
        
        return sb.toString();
    }
}
