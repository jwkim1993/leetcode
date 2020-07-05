class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        
        int bit = 0x1;
        int retVal = 0;
        for(int i = 0 ; i < 31 ; ++i) {
            retVal += (xor & bit)/bit;
            bit = bit << 1;
        }
        
        return retVal;
    }
}
