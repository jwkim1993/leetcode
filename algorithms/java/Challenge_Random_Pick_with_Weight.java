class Solution {
    Random random;
    int N;
    int[] w;
    
    public Solution(int[] w) {
        this.w = w;
        N = 0;
        for(int weigth: w) {
            N += weigth;
        }
        
        random = new Random(System.currentTimeMillis());
    }
    
    public int pickIndex() {
        int idx = random.nextInt(N);
        
        for(int i = 0; i < w.length; ++i) {
            if(idx - w[i] < 0)
                return i;
            idx -= w[i];
        }
        
        return w[w.length - 1];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
