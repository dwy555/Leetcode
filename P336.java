// No.336. Palindrome Pairs
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        if(words == null)return ans;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i],i);
        for(int i = 0; i < words.length; i++){
            int l = 0, r = 0;
            while(l <= r){
                String sub = words[i].substring(l,r);
                Integer j = map.get(new StringBuilder(sub).reverse().toString());
                if(j != null && i!= j && isPali(words[i].substring(l==0?r:0, l==0?words[i].length():l)))
                    ans.add(Arrays.asList(l == 0? new Integer[]{i,j}:new Integer[]{j,i}));
                if(r < words[i].length())r++;
                else l++;
            }
        }
        return ans;
    }
    
    private boolean isPali(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;r--;
        }
        return true;
    }
}
