class Solution {
    public int arrangeCoins(int n) {
        if(n == 0)
            return n;
        
        int i = 1;
        int total = 0;
        while (n - total >= i) {
            total += i++;
        }
        return i-1;
    }
}
