// No.96 Unique Binary Search Trees
class Solution {
    
    public int numTrees(int n) {
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(1);
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= i; j++) {
                sum += list.get(i-j)*list.get(j-1);
            }
            list.add(sum);
        }
        return list.get(n);
    }
    
}
