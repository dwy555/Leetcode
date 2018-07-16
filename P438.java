// No.438 Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<Integer>();
        char[] s_chars = s.toCharArray();
        char[] p_chars = p.toCharArray();
        int[] sat = new int[26];
        for(int i = 0; i < p.length(); i++){
            sat[p_chars[i] - 'a']++;
        }
        for(int i = 0; i <= s.length()-p.length(); i++){
            int[] tem = new int[26];
            int j;
            for(j = 0; j < p.length(); j++){
                int index = s_chars[i+j]-'a';
                tem[index]++;
                if(tem[index] > sat[index])break;
            }
            if(j != p.length())continue;
            boolean isAna = true;
            for(int m = 0; m < 26; m++){
                if(tem[m] != sat[m]){
                    isAna = false;
                    break;
                }
            }
            if(isAna)ans.add(i);
        }
        return ans;
    }
}
