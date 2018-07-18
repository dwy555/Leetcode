// No.387 First Unique Character in a String
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((count[c-'a'] ++)== 0){
                map.put(c, i);
            }else{
                map.remove(c);
            }           
        }
        if(map.size() == 0)return -1;
        Collection values = map.values();
        Collections.
        for(int i = 0; i < s.length(); i++){
            if(map.containsValue(i))return i;
        }
        return -1;
    }
}
