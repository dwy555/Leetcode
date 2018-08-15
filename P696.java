// No.696. Count Binary Substrings
class Solution {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        if(len == 0)return 0;
        char a = s.charAt(0)=='0'?'1':'0';
        int pre = 0, cur = 0;
        int ans = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) != a){
                ans += Math.min(cur,pre);
                pre = cur;
                a = s.charAt(i);
                cur = 1;
            }else{
                cur ++;
            }
        }
        ans += Math.min(cur,pre);
        return ans;
    }
}
