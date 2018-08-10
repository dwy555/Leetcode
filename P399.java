// No.399. Evaluate Division
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] ans = new double[queries.length];
        Map<String, Integer> variables = new HashMap<>();
        int size = 0;
        for(String[] strs: equations){
            if(!variables.containsKey(strs[0]))variables.put(strs[0],size++);
            if(!variables.containsKey(strs[1]))variables.put(strs[1],size++);
        }
        String a,b;
        double[][] graph = new double[size][size];
        for(int i = 0; i < equations.length; i++){
            a = equations[i][0];
            b = equations[i][1];
            int a_in = variables.get(a), b_in = variables.get(b);
            graph[a_in][a_in] = 1.0;
            graph[b_in][b_in] = 1.0;
            graph[a_in][b_in] = values[i];
            graph[b_in][a_in] = 1/values[i];
            for(int start = 0; start < size; start ++){
                if(graph[start][a_in] != 0){
                    graph[start][b_in] = graph[start][a_in]*values[i];
                    graph[b_in][start] = 1/(graph[start][a_in]*values[i]);
                }
            }
            
            for(int end = 0; end < size; end ++){
                if(graph[b_in][end] != 0){
                    graph[a_in][end] = graph[b_in][end]*values[i];
                    graph[end][a_in] = 1/(graph[b_in][end]*values[i]);
                }
            }
            
            for(int m = 0; m < size; m++){
                if(graph[m][a_in] != 0){
                    for(int n = 0; n < size; n++){
                        graph[m][n] = graph[m][a_in]*graph[a_in][b_in]*graph[b_in][n];
                        if(graph[m][n] != 0)graph[n][m] = 1/graph[m][n];
                    }
                }
            }
        }
        for(int i = 0; i < queries.length; i ++){
            a = queries[i][0];
            b = queries[i][1];
            if(!variables.containsKey(a) || !variables.containsKey(b))ans[i] = -1;
            else ans[i] = graph[variables.get(a)][variables.get(b)] == 0? -1:graph[variables.get(a)][variables.get(b)];
        }
        
        return ans;
        
    }
}
