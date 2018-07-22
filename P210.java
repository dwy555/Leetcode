// No.210 Course Schedule II
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        int[] ecount = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++){
            int end = prerequisites[i][0], start = prerequisites[i][1];
            graph[start][end] = 1;
            ecount[end] ++;
        }
        for(int i = 0; i < numCourses; i++){
            if(ecount[i] == 0)
                queue.add(i);
        }
        int num = 0;
        while(queue.size() > 0){
            int curin = queue.poll();
            ans[num] = curin;
            num ++;
            for(int i = 0; i < numCourses; i ++){
                if(graph[curin][i] == 1){
                    graph[curin][i] = 0;
                    if((--ecount[i])==0)
                        queue.add(i);
                }
            }
        }
        if(num == numCourses)return ans;
        return new int[]{};       
    }
}
