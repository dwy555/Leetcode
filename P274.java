// No.274 H-Index
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0)return 0;
        Arrays.sort(citations);     
        int ans = 0;
        int i;
        for(i = len - 1; i > 0; i-- ){
            if(citations[i] >= (len-i) && citations[i-1] <= (len -i))
                return len -i;
        }
        if(citations[i] >= (len-i))return len-i;
        return ans;
    }
}
