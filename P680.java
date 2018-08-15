// No.680. Valid Palindrome II
class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        return isValid(s, 0, len-1,0);
    }
   public boolean isValid(String s, int left, int right, int del){
       if(left >= right)return true;
       if(s.charAt(left) == s.charAt(right))
           return isValid(s,left+1,right-1,del);
       if(del == 1)return false;
       boolean f1 = false, f2 = false;
       if(s.charAt(left) == s.charAt(right-1))
           f1 = isValid(s, left, right-1,1);
       if(s.charAt(left+1) == s.charAt(right))
           f2 = isValid(s, left+1, right,1);
       return f1||f2;
   }
}
