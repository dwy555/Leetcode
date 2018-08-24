// No.415. Add Strings
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length()-1, n = num2.length()-1;
        int flag = 0;
        int sum = 0;
        while(m >= 0 || n >= 0){
            sum = flag;
            if(m >= 0)sum += num1.charAt(m--)-'0';
            if(n >= 0)sum += num2.charAt(n--) - '0';
            sb.append(sum%10);
            flag = sum/10;
        }
        if(flag > 0)sb.append(flag);
        return sb.reverse().toString();
    }
}
