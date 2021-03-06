// No.825. Friends Of Appropriate Ages
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (Integer age: ages) count[age]++;

        int ans = 0;
        for (int i = 0; i <= 120; i++) {
            int countA = count[i];
            for (int j = 0; j <= 120; j++) {
                int countB = count[j];
                if (i * 0.5 + 7 >= j) continue;
                if (i < j) continue;
                if (i < 100 && 100 < j) continue;
                ans += countA * countB;
                if (i == j) ans -= countA;
            }
        }

        return ans;
    }
}
