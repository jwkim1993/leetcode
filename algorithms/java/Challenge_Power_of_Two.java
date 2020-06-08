class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
            return true;
        else if(n <= 0)
            return false;
        
        return (n&(-n)) == n;
    }
}
