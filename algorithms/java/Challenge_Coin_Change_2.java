class Solution {
    public int change(int amount, int[] coins) {
        int[] methods = new int[amount+1];
        methods[0] = 1;
        
        for(int coin: coins) {
            for(int i = coin ; i <= amount; ++i) {
                methods[i] += methods[i-coin];
            }
        }
        
        return methods[amount];
    }
}
