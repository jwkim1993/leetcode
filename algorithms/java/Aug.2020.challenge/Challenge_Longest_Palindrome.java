class Solution {
    public int longestPalindrome(String s) {
        int[] dict = new int[52];
        char[] carr = s.toCharArray();
        
        for(char c: carr)
            ++dict[getIdx(c)];
        
        int retLen = 0;
        for(int count: dict)
            retLen += count/2;
        
        return retLen*2 == s.length() ? retLen*2 : retLen*2 + 1;
    }
    
    public int getIdx(char c) {
        if(c >= 'a')
            return c-'a'+26;
        else
            return c-'A';
    }
}
