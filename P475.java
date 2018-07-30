//No.475 Heaters
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ind_hou = 0, ind_hea = 0;
        int[] rad = new int[houses.length];
        Arrays.fill(rad, Integer.MAX_VALUE);
        int max = Integer.MIN_VALUE;
        while(ind_hou < houses.length && ind_hea < heaters.length){
            if(houses[ind_hou] <= heaters[ind_hea]){
                rad[ind_hou] = Math.min(rad[ind_hou], heaters[ind_hea]-houses[ind_hou]);
                ind_hou++;
            }else{
                ind_hea++;
            }
        }
        ind_hou = houses.length-1;
        ind_hea = heaters.length-1;
        while(ind_hou >=0 && ind_hea >=0){
            if(houses[ind_hou] > heaters[ind_hea]){
                rad[ind_hou] = Math.min(rad[ind_hou], houses[ind_hou]-heaters[ind_hea]);
                max = Math.max(rad[ind_hou], max);
                ind_hou--;
            }else{
                ind_hea--;
            }
        }
        while(ind_hou >=0){
            max = Math.max(rad[ind_hou], max);
            ind_hou--;
        }
        return max;
    }
}
