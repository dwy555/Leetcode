// No.126. Word Ladder II
class Solution {
    List<List<String>> ans = new LinkedList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        set.add(beginWord);
        ArrayList<String> list = new ArrayList<String>();
        bfs(beginWord, endWord, set, neighbors, distance);
        dfs(beginWord, endWord, list, neighbors, distance);
        return ans;
        
    }
    
    private void bfs(String beginWord, String endWord, Set<String> set, Map<String, List<String>> neighbors, Map<String, Integer> distance){
        Queue<String> q = new LinkedList<>();
        for(String word: set)
            neighbors.put(word, new ArrayList<String>());
        q.add(beginWord);
        distance.put(beginWord, 0);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean found = false;
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                int curdis = distance.get(cur);
                ArrayList<String> curnb = getNeibors(cur, set);
                for(String nb: curnb){
                    neighbors.get(cur).add(nb);
                    if(distance.get(nb) == null){
                        distance.put(nb, curdis+1);
                        if(endWord.equals(nb))
                            found = true;
                        else
                            q.add(nb);
                    }
                }
            }
            if(found)break;
        }
    }
    
    private ArrayList<String> getNeibors(String cur, Set<String> set ){
        ArrayList<String> list = new ArrayList<String>();
        char[] chars = cur.toCharArray();
        for(int i = 0; i < cur.length(); i++){
            char old = chars[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c != old){
                    chars[i] = c;
                    if(set.contains(String.valueOf(chars)))
                        list.add(String.valueOf(chars));
                }
            }
            chars[i] = old;
        }
        return list;
    }
    
    private void dfs(String cur, String endWord, ArrayList<String> list, Map<String, List<String>> neighbors, Map<String, Integer> distance){
        list.add(cur);
        if(cur.equals(endWord)){
            ans.add(new ArrayList<String>(list));
        }else{
            for(String nb: neighbors.get(cur)){
                if(distance.get(cur)+1 == distance.get(nb))
                    dfs(nb, endWord, list, neighbors, distance);
            }
        }
        list.remove(list.size()-1);
    }
    
}
