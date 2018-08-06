// No.354 Russian Doll Envelopes
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0] == e2[0])
                    return e2[1]-e1[1];
                return
                    e1[0]-e2[0];
            }
        });
        
        int[] dp = new int[envelopes.length];
        int size = 0;
        for(int[] env: envelopes){
            int i = 0, j = size;
            while(i != j){
                int mid = (i+j)/2;
                if(dp[mid] < env[1])i= mid+1;
                else j = mid;
            }
            dp[i] = env[1];
            if(i == size)size++;
        }
        return size;
        
    }
}
