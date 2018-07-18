// No.134 Gas Station
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0, start = 0, rest = 0;
        for(int i = 0; i < len; i++){
            rest += gas[i]-cost[i];
            if(rest < 0){
                start = i+1;
                sum += rest;
                rest = 0;
            }  
        }
        return sum+rest < 0?-1:start;
        
    }
}
