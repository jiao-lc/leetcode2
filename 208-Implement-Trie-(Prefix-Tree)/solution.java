class TrieNode {
    public char val;
    public boolean leaf; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] str = word.toCharArray();
        TrieNode node = root;
        for(char c : str) {
            TrieNode[] sub = node.children;
            if(sub[c - 'a'] == null) {
                sub[c - 'a'] = new TrieNode(c);
            } 
            node = sub[c - 'a'];
        }
        node.leaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] str = word.toCharArray();
        TrieNode node = root;
        for(char c : str) {
            TrieNode[] sub = node.children;
            if(sub[c - 'a'] == null) {
                return false;
            } 
            node = sub[c - 'a'];
        }
        return node.leaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] str = prefix.toCharArray();
        TrieNode node = root;
        for(char c : str) {
            TrieNode[] sub = node.children;
            if(sub[c - 'a'] == null) {
                return false;
            } 
            node = sub[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");