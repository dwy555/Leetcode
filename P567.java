// No.567 Permutation in String
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2)return false;
        int[] count1 = new int[26], count2 = new int[26];
        for(int i = 0; i < len1; i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i <= len2 - len1; i++){
            if(isEqual(count1, count2))return true;
            if(i+len1 == len2)break;
            count2[s2.charAt(i)-'a']--;
            count2[s2.charAt(i+len1)-'a']++;
        }
        return false;
    }
    
    public boolean isEqual(int[] c1, int[] c2){
        for(int i = 0; i < 26; i++){
            if(c1[i] != c2[i])return false;
        }
        return true;
    }
}
