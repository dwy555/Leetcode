// No.38. Count and Say
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        while(n > 1){
            StringBuilder str = new  StringBuilder();
            char cur = '0';
            int count = 0;
            for(int i = 0; i < sb.length(); i++){
                if(cur != sb.charAt(i)){
                    if(count > 0)str.append(count).append(cur);
                    cur = sb.charAt(i);
                    count = 1;
                }else{
                    count ++;
                }
            }
            str.append(count).append(cur);
            sb = str;
            n--;
        }
        return sb.toString();
    }
}
