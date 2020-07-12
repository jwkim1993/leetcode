public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int retVal = 0;
        
        for(int i = 31 ; i >= 0 ; --i) {
            retVal = retVal << 1;
            retVal = retVal | n & 0x1;
            n = n >> 1;
        }
        
        return retVal;
    }
}
