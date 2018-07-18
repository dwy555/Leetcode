// No.43 Multiply Strings
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] mul = new int[len1+len2];
        for(int i = len1 -1; i >= 0; i-- ){
            for(int j = len2 -1; j >= 0; j--){
                mul[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }

        int rest = 0, cur;

        for(int i = mul.length-1; i >= 0; i--){
            cur = mul[i]+rest;
            rest = cur/10;
            mul[i] = cur % 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mul.length; i++)sb.append(mul[i]);
        while(sb.length() != 0 && sb.charAt(0) == '0')sb.deleteCharAt(0);
        return sb.length() == 0? "0" : sb.toString();
    }
    
    
}
