// No. 621 Task Scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = -1;
        int num = 0;
        for(char task: tasks){
            count[task-'A'] ++;
            max = Math.max(count[task-'A'], max);
        }
        for(int c: count){
            num += c == max?1:0;
        }
        return Math.max(tasks.length, (max-1)*(n+1)+num);
    }
}
