// No.12 Integer to Roman
class Solution {
    public String intToRoman(int num) {
        String[] roman = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            for(int i = 0; i < nums.length; i++){
                if(num >= nums[i]){
                    num -= nums[i];
                    sb.append(roman[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
