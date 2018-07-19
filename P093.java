// No93 Restore IP Addresses
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        for(int a = 1; a <= 3; a++ )
        for(int b = 1; b <= 3; b++ )
        for(int c = 1; c <= 3; c++ )
        for(int d = 1; d <= 3; d++ ){
           if(a + b + c + d == s.length()){
               String aStr = s.substring(0,a);
               String bStr = s.substring(a, a+b);
               String cStr = s.substring(a+b,a+b+c);
               String dStr = s.substring(a+b+c,s.length());
               if(Integer.parseInt(aStr) > 255 || (aStr.length() > 1 && aStr.startsWith("0")) || 
                  Integer.parseInt(bStr) > 255 || (bStr.length() > 1 && bStr.startsWith("0")) ||
                  Integer.parseInt(cStr) > 255 || (cStr.length() > 1 && cStr.startsWith("0")) ||
                  Integer.parseInt(dStr) > 255 || (dStr.length() > 1 && dStr.startsWith("0")))
                   continue;
               StringBuilder sb = new StringBuilder(aStr).append(".").append(bStr).append(".").append(cStr).append(".").append(dStr);
               ans.add(sb.toString());
               
           }
        }
        return ans;
        
        
    }
}
