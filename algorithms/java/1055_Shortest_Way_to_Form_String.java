class Solution {
    public int shortestWay(String source, String target) {
        if(target == null || target.length() == 0)
            return 0;
        if(source == null || source.length() == 0)
            return -1;
        
        char[] sArr = source.toCharArray();
        int retSS = 0;
        int ptr = 0;
        
        int tLen = target.length();
        int sLen = source.length();
        
        for(int i = 0 ; i < tLen ; ++i ) {
            int tmpPtr = ptr;
            char tChar = target.charAt(i);
            
            while(tmpPtr < sLen && tChar != sArr[tmpPtr])
                ++tmpPtr;
            
            if(tmpPtr == sLen) {
                ++retSS;
                tmpPtr = 0;
                while(tmpPtr < ptr && tChar != sArr[tmpPtr])
                    ++tmpPtr;
                
                if(tmpPtr == ptr)
                    return -1;
            }
            
            ptr = tmpPtr + 1;
        }
        
        return retSS+1;
    }
}
