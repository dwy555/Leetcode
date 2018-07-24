//No.345 Reverse Vowels of a String
class Solution {
    public String reverseVowels(String s) {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>();
        for(Character c: vowels)set.add(c);
        char[] chars = s.toCharArray();
        int left = 0, right = s.length()-1;
        while(left < right){
            while(!set.contains(chars[left]) && left < right)left++;
            while(!set.contains(chars[right]) && left < right)right--;
            char tem = chars[left];
            chars[left] = chars[right];
            chars[right] = tem;
            left++;right--;
        }
        return String.valueOf(chars);
    }
}
