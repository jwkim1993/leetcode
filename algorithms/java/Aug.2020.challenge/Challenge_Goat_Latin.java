class Solution {
    int numWord;
    char[] vowelSet;
    StringBuilder sb;
    
    public String toGoatLatin(String S) {
        char postfix = 0;
        numWord = 0;
        sb = new StringBuilder();
        vowelSet = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        
        int idx = 0;
        while (idx < S.length()) {
            
            if(!isVowel(S.charAt(idx))) {
                postfix = S.charAt(idx);
                ++idx;
            }
            
            while(idx < S.length() && S.charAt(idx) != ' ') {
                sb.append(S.charAt(idx));
                ++idx;
            }
            
            if(postfix != 0)
                sb.append(postfix);
            
            appendAs();
            sb.append(' ');
            ++idx;
            ++numWord;
            postfix = 0;
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    public void appendAs() {
        sb.append("ma");
        for(int i = 0 ; i < numWord+1 ; ++i) {
            sb.append('a');
        }
    }
    
    public boolean isVowel(char c) {
        for(char vowel : vowelSet) {
            if(c == vowel)
                return true;
        }
        
        return false;
    }
}
