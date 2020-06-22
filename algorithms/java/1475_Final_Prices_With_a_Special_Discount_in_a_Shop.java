class Solution {
    public int[] finalPrices(int[] prices) {
        if(prices.length == 0)
            return new int[0];
        
        int N = prices.length;
        int[] retArr = new int[N];
        
        for(int i = 0 ; i < N ; ++i) {
            retArr[i] = prices[i];
            for(int j = i+1 ; j < N; ++j) {
                if(prices[j] <= prices[i]) {
                    retArr[i] -= prices[j];
                    break;
                }
            }
        }
        
        return retArr;
    }
}
