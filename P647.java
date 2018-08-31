// No.647. Palindromic Substrings
class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            isPalindromic(i,i,s);
            isPalindromic(i,i+1,s);
        }
        return count;
    }
    
    private void isPalindromic(int left, int right, String s){
        if(left < 0 || right >= s.length())return;
        if(s.charAt(left) == s.charAt(right)){
            count += 1;
            isPalindromic(left-1,right+1,s);
        }
    }
}
