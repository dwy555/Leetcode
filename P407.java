// No.407. Trapping Rain Water II
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if(m == 0)return 0;
        int n = heightMap[0].length;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            pq.add(new int[]{i,0,heightMap[i][0]});
            pq.add(new int[]{i,n-1,heightMap[i][n-1]});
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        
        for(int j = 0; j < n; j++){
            pq.add(new int[]{0,j, heightMap[0][j]});
            pq.add(new int[]{m-1, j, heightMap[m-1][j]});
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            for(int[] d: dir){
                int i = cell[0]+d[0], j = cell[1]+d[1];
                if(i >= m || i < 0 || j >= n || j < 0 || visited[i][j])continue;
                ans += Math.max(0, cell[2] - heightMap[i][j]);
                pq.add(new int[]{i,j,Math.max(cell[2], heightMap[i][j])});
                visited[i][j] = true;
            }
        }
        return ans;
        
    }
}
