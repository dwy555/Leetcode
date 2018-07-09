// No. 621 Task Scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int num = 0, time = 0;;
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i]-'A']++;
        }
        Arrays.sort(count);
        while(count[25] > 0){
            for(int i = 0; i < n+1; i++){
                if(count[25] == 0)break;
                if(i < 26 && count[25-i] > 0){
                    count[25-i] --;
                }
                time ++;
            }
            Arrays.sort(count);
        }
        return time;
    }
}
