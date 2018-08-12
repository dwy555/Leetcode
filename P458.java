// No.458. Poor Pigs
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int num = 0;
        return (int)Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie + 1));
    }
}
