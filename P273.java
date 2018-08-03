// No.273 Integer to English Words
class Solution {
    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        String[] strs = {"Billion","Million","Thousand","Hundred","Ninety","Eighty","Seventy","Sixty","Fifty","Forty","Thirty","Twenty","Nineteen","Eighteen","Seventeen","Sixteen","Fifteen","Fourteen","Thirteen","Twelve","Eleven","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One"};
        int nums[] = {1000000000,1000000,1000,100,90,80,70,60,50,40,30,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};   
        return toWords(num,strs,nums,0);
    }
    
    public String toWords(int num, String[] strs, int[] nums, int start){
        String ans = "";
        if(num == 0)return "";
        for(int i = start; i < nums.length; i ++){
            if(num/nums[i] != 0){
                int pre = num/nums[i];
                int rear = num%nums[i];
                if(num >= 100)ans += toWords(pre,strs,nums,i+1)+" ";
                ans += strs[i];
                String r = toWords(rear,strs,nums,i+1);
                if(!"".equals(r))ans += " "+r;
                return ans;
            }
        }
        return "";
    }
    
    
    
    
    
}
