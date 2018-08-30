// No.171 Excel Sheet Column Number
class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for(char c: s.toCharArray()){
            sum = sum*26 + (c-'A'+1);
        }
        return sum;
    }
}
