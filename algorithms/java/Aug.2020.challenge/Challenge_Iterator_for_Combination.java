class CombinationIterator {

    int[] ptrs;
    String chars;
    boolean next;
    
    public CombinationIterator(String characters, int combinationLength) {
        next = true;
        this.ptrs = new int[combinationLength];
        for(int i = 0 ; i < combinationLength; ++i) {
            ptrs[i] = i;
        }
        this.chars = characters;
    }
    
    public String next() {
        StringBuilder sb = new StringBuilder();
        for(int idx: ptrs)
            sb.append(chars.charAt(idx));
        
        int limit = chars.length() - 1;
        int startIdx = -1;
        for(int i = ptrs.length - 1 ; i >= 0 ; --i) {
            if(ptrs[i] < limit) {
                ++ptrs[i];
                startIdx = i+1;
                break;
            }
            --limit;
        }
        
        if(startIdx == -1) { // hasNext = false; 
            next = false;
            return sb.toString();
        }
        
        for(int i = startIdx ; i < ptrs.length ; ++i) {
            ptrs[i] = ptrs[i-1] + 1;
        }
        
        return sb.toString();
    }
    
    public boolean hasNext() {
        return next;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
