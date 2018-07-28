// No.416 Partition Equal Subset Sum
class Solution {
    public boolean canPartition(int[] nums) {
        Stack<Integer> st = new Stack<>();
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for(Integer num: nums)
            sum += num;
        if(sum%2 != 0)return false;
        int half = sum/2;
        int index = len -1;
        int greedy = 0;
        do{
            while(index >= 0){
                if(nums[index] > half)return false;
                greedy += nums[index];
                st.push(index);
                if(greedy == half)return true;
                if(greedy > half){
                    greedy -= nums[index];
                    st.pop();
                }
                index --;
            }
            if(st.isEmpty())return false;
            index = st.pop();
            greedy -= nums[index];
            index--;
        }while(!st.isEmpty());
        return false;
    }
    
}
