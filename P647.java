// No.647. Palindromic Substrings
class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        
        for(int i = 0; i < s.length()-1; i++){
            palindromic(s,i,i);
            palindromic(s,i,i+1);
        }
        
        return count+1;
    }
    
    
    public void palindromic(String s, int i, int j){
        if(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count ++;
            palindromic(s, i-1, j+1);
        }
    }
}
