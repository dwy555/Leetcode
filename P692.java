// No.692. Top K Frequent Words
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new LinkedList<>();
        Arrays.sort(words);
        int max = 0;
        int count = 0;
        String str = "";
        List<String> list;
        Map<Integer,List<String>> map = new HashMap<>();
        for(String word: words){
            if(word.equals(str))count++;
            else{
                if(count > 0){
                    max = Math.max(max,count);
                    list = map.get(count) == null? new LinkedList():map.get(count);
                    list.add(str);
                    map.put(count,list);
                }
                str = word;
                count = 1;
            }
        }
        max = Math.max(max,count);
        list = map.get(count) == null? new LinkedList():map.get(count);
        list.add(str);
        map.put(count,list);
        while(k > 0){
            if(map.containsKey(max)){
                list = map.get(max);
                int num = Math.min(list.size(), k);
                for(int i = 0; i < num; i++){
                    ans.add(list.get(i));
                }
                k -= num;
            }
            max--;
        }
        
        return ans;
    }
}
