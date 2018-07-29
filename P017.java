// No.17 Letter Combinations of a Phone Number
class Solution {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        String[] letters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String str = "";
        Deque<String> que = new LinkedList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int digit = digits.charAt(i)-'2';
            String lts = letters[digit];
            int size = que.size();
            if(size == 0){
                for(Character c: lts.toCharArray()){
                    que.add(str+c);
                }
            }
            for(int j = 0; j < size; j++){
                str = que.poll();
                for(Character c: lts.toCharArray()){
                    que.add(str+c);
                }
            }
        }
        while(!que.isEmpty()){
            list.add(que.poll().toString());
        }
        return list;
    }
}
