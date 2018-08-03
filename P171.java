// No.171 Excel Sheet Column Number
class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int factor = 1;
        for(int i = s.length() - 1; i >= 0 ; i--){
            ans += factor*(s.charAt(i)-'A'+1);
            factor *= 26;
        }
        return ans;
    }
}
