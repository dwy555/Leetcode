// No.336. Palindrome Pairs
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> ans = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);
        for(int j = 0; j < words.length; j++){
            for(int i = 0; i < words[j].length()+1; i++){
                String s = new StringBuilder(words[j].substring(0,i)).reverse().toString();
                StringBuilder sb = new StringBuilder(words[j]).append(s);
                if(sb.toString().equals(sb.reverse().toString())){
                    if(map.containsKey(s) && map.get(s) != j){
                        ans.add(Arrays.asList(j,map.get(s)));
                    }
                }
                s = new StringBuilder(words[j].substring(words[j].length()-i)).reverse().toString();
                StringBuilder sb2 = new StringBuilder(s).append(words[j]);
                if(sb2.toString().equals(sb2.reverse().toString())){
                    if(map.containsKey(s) && map.get(s) != j){
                        ans.add(Arrays.asList(map.get(s),j));
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
