// No.208. Implement Trie (Prefix Tree)

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}


public class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode crt = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (crt.children[index] == null) {
                crt.children[index] = new TrieNode();
            }
            crt = crt.children[index];
        }
        crt.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = end(word);
        return node != null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = end(prefix);
        return node != null;
    }
    
    
    public TrieNode end(String str){
        char[] chs = str.toCharArray();
        TrieNode currt = root;
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            if (currt.children[index] == null) {
                return null;
            }
            currt = currt.children[index];
        }
        return currt;
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
