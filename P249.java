//No.249 Group Shifted Strings
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        List<String> list;
        for(String str: strings){
            StringBuilder sb = new StringBuilder("a");
            int tran = str.charAt(0) - 'a';
            for(int i = 1; i < str.length(); i++){
                if(str.charAt(i) - tran < 'a')
                    sb.append(str.charAt(i)+(26-tran));
                else
                    sb.append(str.charAt(i)-tran);
            }
            String ori = sb.toString();
            if(!map.containsKey(ori)){
                map.put(ori,ans.size());
                list = new LinkedList<>();
                list.add(str);
                ans.add(list);
            }else{
                int index = map.get(ori);
                list = ans.get(index);
                list.add(str);   
                ans.set(index, list);
            }
            
        }
        return ans;
    }
}
