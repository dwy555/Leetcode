// No.Regular Expression Matching
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)return s.length() == 0;
        boolean first = s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        if(p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s,p.substring(2)) || (first && isMatch(s.substring(1), p));
        else
            return first && isMatch(s.substring(1), p.substring(1));
    }
}
