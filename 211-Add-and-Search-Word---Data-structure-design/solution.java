public class WordDictionary {
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (cur.children[x - 'a'] == null) {
                cur.children[x - 'a'] = new TrieNode();
            }
            cur = cur.children[x - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root,word.toCharArray(),0);
    }
    
    private boolean search(TrieNode root, char[] word, int index) {
        if (root == null) return false;
        if (index == word.length) {
            return root.isWord;
        }
        char x = word[index];
        if (x == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(root.children[i], word, index + 1)) return true;
            }
            return false;
        } else {
            return search(root.children[x - 'a'], word, index + 1); 
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");