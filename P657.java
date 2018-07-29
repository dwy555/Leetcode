// No.657 Judge Route Circle
class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0,rl = 0;
        for(Character c: moves.toCharArray()){
            if(c == 'U')ud++;
            else if(c == 'D')ud--;
            else if(c == 'R')rl++;
            else rl--;
        }
        return (ud==0) && (rl==0);
    }
}
