// No.406 Queue Reconstruction by Height
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int num = people.length;
        Map<Integer, LinkedList<Integer>> que = new HashMap<Integer, LinkedList<Integer>>();
        LinkedList<Integer> heights = new LinkedList<Integer>();
        LinkedList<Integer> fronts = new LinkedList<Integer>();
        LinkedList<Integer> list;
        int[][] ans = new int[num][2];
        for(int i = 0; i < num; i++){
            int front = people[i][1], height = people[i][0];
            if(!que.containsKey(front)){
                que.put(front, new LinkedList<Integer>());
            }
            list = que.get(front);
            list.add(height);
            que.put(front,list);
        }
        for(int i = 0; i < num; i++){
            if(!que.containsKey(i))continue;
            list = que.get(i);
            Collections.sort(list);
            for(int j = list.size()-1; j > -1; j -- ){
                int index = 0, count = 0;
                int cur = list.get(j);
                for(Integer h: heights){
                    if(count == i)break;
                    if(cur <= h)count ++;
                    index ++;
                }
                heights.add(index,cur);
                fronts.add(index,i);
            }
        }
        
        for(int i = 0; i < num; i++){
            ans[i][0] = heights.get(i);
            ans[i][1] = fronts.get(i);
        }
        return ans;
    }
}
