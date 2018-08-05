// NO.67 Add Binary
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1, n = b.length()-1;
        int add = 0;
        while(m >= 0 || n >= 0){
            int sum = add;
            if(m >= 0) sum += (a.charAt(m)-'0');
            if(n >= 0) sum += (b.charAt(n) - '0');
            sb.append(sum%2);
            add = sum / 2;
            m--;n--;
        }
        if(add == 1)sb.append("1");
        return sb.reverse().toString();
    }
}
