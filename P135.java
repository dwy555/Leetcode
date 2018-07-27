// No.135 Candy
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                count[i] = count[i-1] + 1;
            }
        }
        int sum = count[n-1];
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                count[i] = Math.max(count[i],count[i+1]+1);
            }
            sum += count[i];
        }
        return sum+n;
    }
}
