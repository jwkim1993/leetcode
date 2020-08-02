class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0)
            return true;
        
        char firstChar = word.charAt(0);
        if(firstChar >= 'a' && firstChar <= 'z')
            return isInValidRange(word, 1, 'a', 'z');
        else
            return isInValidRange(word, 1, 'a', 'z') || isInValidRange(word, 1, 'A', 'Z');
    }
    
    public boolean isInValidRange(String word, int idx, char a, char z) {
        for(int i = idx ; i < word.length() ; ++i) {
            char tmp = word.charAt(i);
            if(tmp < a || tmp > z)
                return false;
        }
        
        return true;
    }
}
