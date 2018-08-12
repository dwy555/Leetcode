class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int sublen = 1;
        while(sublen <= len/2){
            if((len%sublen) == 0){
                if(s.substring(0, sublen).equals(s.substring(len-sublen))){
                    if(repeat(s, sublen))return true;
                }
            }
            sublen ++;
        }
        return false;
    }
    
    private boolean repeat(String s, int sublen){
        String str = s.substring(0, sublen);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length()/sublen; i++)
            sb.append(str);
        return sb.toString().equals(s);
    }
}
