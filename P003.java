//	No.3 Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0, start = 0;
        char[] str = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < len; i ++){
            if(map[str[i]] > 0){
                start = Math.max(start,map[str[i]]);
            }
            map[str[i]] = i+1;
            max = Math.max(max, i-start + 1);
        }
        return max;
    }
}
