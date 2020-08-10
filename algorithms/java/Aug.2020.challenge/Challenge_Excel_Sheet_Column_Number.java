class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int N = s.length();
        int ret = 0;
        
        for(int i = N-1 ; i >= 0 ; --i) {
            char tmp = s.charAt(i);
            ret += getIdx(tmp)*Math.pow(26, N-1-i);
        }
        
        return ret;
    }
    
    public int getIdx(char x) {
        return x - 'A' + 1;
    }
}
