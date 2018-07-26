// No.684 Redundant Connection
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[][] graph = new int[n+1][n+1];
        for(int i = 0; i < edges.length; i ++){
            int node1 = edges[i][0], node2 = edges[i][1];
            if(graph[node1][node2] == 1)return edges[i];
            graph[node1][node2] = graph[node2][node1] = 1;   
            for(int j = 1; j <= n; j++){
                if(graph[node1][j] == 1) {
                    graph[j][node2] = graph[node2][j] = 1;
                    for (int m = 1; m <= n; m++) {
                        if (graph[node2][m] == 1) {
                            graph[m][node1] = graph[node1][m] = 1;
                            graph[j][m] = graph[m][j] = 1;
                        }
                    }
                }
            }
             
        }
        return new int[]{};
    }
}
