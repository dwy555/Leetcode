// No.310 Minimum Height Trees
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1){
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
        List<Integer> leaves = new ArrayList<Integer>();
        
        for (int i = 0; i < n; ++i) adj.add(new HashSet<Integer>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}
