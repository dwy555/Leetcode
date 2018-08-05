// No.389 Find the Difference
class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for(Character c: s.toCharArray()){
            count[c-'a']++;
        }
        for(Character c: t.toCharArray()){
            if(count[c-'a'] == 0)return c;
            count[c-'a']--;
        }
        return '0';
    }
}
