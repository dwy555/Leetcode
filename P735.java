// No.735 Asteroid Collision
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int len = asteroids.length;
        if(len == 0)return new int[]{};
        st.push(asteroids[0]);
        boolean isSave = true;
        for(int i = 1; i < len; i ++){
            isSave = true;
            if(asteroids[i] > 0)st.push(asteroids[i]);
            else{
                if(st.isEmpty() || st.peek() < 0){st.push(asteroids[i]);continue;}
                while(!st.isEmpty() && st.peek() > 0){
                    if(st.peek() < -asteroids[i])st.pop();
                    else if(st.peek() == -asteroids[i]){isSave = false;st.pop();break;}
                    else {isSave = false;break;}
                }
                if(isSave)st.push(asteroids[i]);
            }
        }
        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
        
        
    }
}
