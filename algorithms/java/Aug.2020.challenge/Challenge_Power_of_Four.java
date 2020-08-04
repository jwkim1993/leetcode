class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0)
            return false;
        
        if(num != (num & ~num+1))
            return false;
        
        if(num != (num & 0x55555555))
            return false;
        
        return true;        
    }
}
