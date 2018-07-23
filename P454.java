// NO.454 4Sum II
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer numA: A)
            for(Integer numB:B){
                if(!map.containsKey(numA+numB)){
                    map.put(numA+numB,1);
                }else{
                    map.put(numA+numB,map.get(numA+numB)+1);
                }
            }
        int count = 0;
        for(Integer numC: C)
            for(Integer numD: D){
                if(map.containsKey(-(numC+numD)))
                    count += map.get(-(numC+numD));
            }
        
        return count;
    }
}
