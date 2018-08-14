// No.670. Maximum Swap
class Solution {
    public int maximumSwap(int num) {
        if(num < 10)return num;
        char[] input = String.valueOf(num).toCharArray();
        for(int i = 0; i < input.length-1; i++){
            int max = i;
            for(int j = input.length-1; j > i; j--){
                if(input[max] < input[j])max = j;
            }
            if(max != i){
                char tmp = input[i];
                input[i] = input[max];
                input[max] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(input));
    }
}
