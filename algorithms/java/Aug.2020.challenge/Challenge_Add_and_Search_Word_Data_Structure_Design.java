class WordDictionary {

    public static class Trie {
        public Trie[] children;
        public boolean last;
        
        public Trie() {
            children = new Trie[26];
            last = false;
        }
    }
    
    public int getIdx(char x) {
        return x - 'a';
    }
    
    Trie root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie cur = root;
        for(int i = 0 ; i < word.length() ; ++i) {
            char tmp = word.charAt(i);
            if(cur.children[getIdx(tmp)] == null)
                cur.children[getIdx(tmp)] = new Trie();
            
            cur = cur.children[getIdx(tmp)];
        }
        
        cur.last = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return recurSearch(word, 0, root);
    }
    
    public boolean recurSearch(String word, int idx, Trie cur) {
        if(idx == word.length())
            return cur.last;
        
        char tmp = word.charAt(idx);
        if(tmp != '.') {
            if(cur.children[getIdx(tmp)] == null)
                return false;
            else
                return recurSearch(word, idx+1, cur.children[getIdx(tmp)]);
        }
        
        for(int i = 0 ; i < 26 ; ++i) {
            if(cur.children[i] != null && recurSearch(word, idx+1, cur.children[i]))
                return true;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
