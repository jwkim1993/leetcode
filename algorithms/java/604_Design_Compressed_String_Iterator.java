class StringIterator {
    
    public static class CInt {
        int val;
        public CInt(String val) {
            this.val = Integer.parseInt(val);
        }
        
        public void decrement() {
            --this.val;
        }
        
        public boolean equalsToInt(int val) {
            return this.val == val;
        }
    }

    List<Pair<Character, CInt>> letters;
    int N;
    int ptr;
    
    public StringIterator(String compressedString) {
        ptr = 0;
        letters = new ArrayList<>();
        if(compressedString.length() == 0) {
            N = 0;
            return;
        }
        
        char cur = compressedString.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i < compressedString.length() ; ++i) {
            char tmp = compressedString.charAt(i);
            if('0' <= tmp && tmp <= '9')
                sb.append(tmp);
            else {
                letters.add(new Pair<>(cur, new CInt(sb.toString())));
                cur = tmp;
                sb = new StringBuilder();
            }
        }
        
        letters.add(new Pair<>(cur, new CInt(sb.toString())));
        N = letters.size();
    }
    
    public char next() {
        if(!hasNext())
            return ' ';
        
        letters.get(ptr).getValue().decrement();
        return letters.get(ptr).getKey();
    }
    
    public boolean hasNext() {
        if(ptr == N)
            return false;
        
        if(letters.get(ptr).getValue().equalsToInt(0))
            ++ptr;
        
        if(ptr == N)
            return false;
        
        return true;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
