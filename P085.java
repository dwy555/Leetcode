// No.85 Maximal Rectangle
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n]; 
        Arrays.fill(right, n);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(l, left[j]);
                }else {
                    l = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(r, right[j]);
                    ans = Math.max(ans, height[j] * (right[j] - left[j]));
                }else {
                    r = j;
                }
            }
        }
        return ans;
    }
}
