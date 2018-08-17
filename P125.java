// No.125. Valid Palindrome
class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = len -1;
        while(left < right){
            while(left < len && !Character.isLetterOrDigit(chars[left]))left++;
            while(right > -1 && !Character.isLetterOrDigit(chars[right]))right--;
            if(left > right)break;
            if(chars[left] != chars[right])return false;
            left++;right--;
        }
        return true;
    }
}
