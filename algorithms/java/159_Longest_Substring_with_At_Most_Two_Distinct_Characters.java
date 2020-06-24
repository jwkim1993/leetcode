class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2)
            return s.length();
        
        int N = s.length();
        
        char l1 = s.charAt(0);
        char l2 = l1;
        int retVal = 0;
        int tmpMax = 0;
        
        for(int i = 0 ; i < N ; ++i) {
            char elem = s.charAt(i);
            
            if(elem == l1) {
                l1 = l2;
                l2 = elem;
            }
            if(elem == l2) {
                tmpMax++;
                continue;
            }
            
            if(tmpMax > retVal)
                retVal = tmpMax;
            
            tmpMax = 1;
            int pos = i-1;
            
            while(pos >= 0 && s.charAt(pos) == l2) {
                ++tmpMax;
                --pos;
            }
            
            l1 = l2;
            l2 = elem;            
        }
        
        return retVal > tmpMax ? retVal : tmpMax;
    }
}
