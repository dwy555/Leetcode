// No.556 Next Greater Element III
class Solution {
    public int nextGreaterElement(int n) {
        if(n <= 10)return -1;
        char[] str = String.valueOf(n).toCharArray();
        int i,j;
        
        for(i = str.length - 2; i >= 0; i--){
            if(str[i] < str[i+1])break;
        }
        if(i == -1)return -1;
        
        for(j = i+2; j < str.length; j++){
            if(str[i] >= str[j])break;
        }
        change(str,i,j-1);
        int m = i+1, k = str.length - 1;
        while(m < k){
            change(str,m,k);
            m++;k--;
        }
        long ans = Long.parseLong(String.valueOf(str));
        return ans > Integer.MAX_VALUE? -1:(int)ans;
    }
    
    public void change(char[] str, int i, int j){
        char tem = str[i];
        str[i] = str[j];
        str[j] = tem;
    }
}
