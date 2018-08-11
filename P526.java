// No.526. Beautiful Arrangement
class Solution {
    private int count = 0;
    public int countArrangement(int N) {
        if(N <= 1)return 1;
        int[] nums = new int[N+1];
        for(int i = 0; i <= N; i++)nums[i] = i;
        arrange(nums, N);
        return count;
    }
    
    public void arrange(int[] nums, int start){
        if(start == 0){
            count++;
            return;
        }
        
        for(int i = start; i > 0; i--){
            swap(nums, start, i);
            if(nums[start] % start == 0 || start % nums[start] == 0)arrange(nums,start - 1);
            swap(nums, i, start);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
    
    
    
    
    
}
