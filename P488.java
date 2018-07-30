// No.488 Zuma Game
class Solution {
    public int findMinStep(String board, String hand) {        
        List<Character> boardList = new ArrayList<>();
        for (char c : board.toCharArray())
            boardList.add(c);
        Map<Character,Integer> map = new HashMap<>();
        for(Character c: "RYBGW".toCharArray())
            map.put(c,0);
        for(Character h: hand.toCharArray())
            map.put(h, map.get(h)+1);
        return minStep(boardList, map);      
    }
    
    public int minStep(List<Character> boardList, Map<Character,Integer> map){
        boolean needClean = true;
        while(needClean){
            int count = 0;
            needClean = false;
            for (int i = 0; i<boardList.size(); i++) {
                char c = boardList.get(i);
                count++;
                if (i == boardList.size() - 1 || boardList.get(i+1) != c) {
                    if (count >= 3) {
                        for (int j = 0; j<count; j++) {
                            boardList.remove(i-j);
                        }
                        needClean = true;
                        // break;
                    }
                    count = 0;
                }
                if(needClean)break;
            }
            
        }
            
        if (boardList.size() == 0) return 0;
        int num = 0;
        for (int val : map.values()) {
            num += val;
            if (val > 0) break; 
        }
        if (num == 0) return -1;
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<boardList.size(); i++) {
            char c = boardList.get(i);
            count++;
            if (i == boardList.size() - 1 || boardList.get(i+1) != c) {
                int missing = 3 - count;
                if (map.get(c) >= missing) {
                    map.put(c, map.get(c) - missing);
                    List<Character> smallerBoard = new ArrayList<>(boardList);
                    for (int j = 0; j<count; j++) {
                        smallerBoard.remove(i-j);
                    }
                    int smallerFind = minStep(smallerBoard, map);
                    if ( smallerFind != -1 ) {
                        min = Math.min(smallerFind + missing, min);
                    }
                    map.put(c, map.get(c) + missing);
                }
                count = 0;
            }
        }
        return (min == Integer.MAX_VALUE) ? -1 : min;
            
    }
}
