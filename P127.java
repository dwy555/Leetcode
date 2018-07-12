// No.127 Word Ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(endWord);
        HashSet<String> visit_set = new HashSet<String>();
        visit_set.add(beginWord);
        int dist = 1;
        while (!visit_set.contains(endWord)) {
            HashSet<String> tran_world = new HashSet<String>();
            for (String ele : visit_set) {
                for (int i = 0; i < ele.length(); i++) {
                    char[] chars = ele.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            tran_world.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            dist ++;
            if (tran_world.size() == 0) return 0;
            visit_set = tran_world;
        }
        return dist;
    }
}
