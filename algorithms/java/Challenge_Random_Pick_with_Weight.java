class Solution {
    int[] w;
    Random r;
    public Solution(int[] w) {
        this.w = w;
        r = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
    }
    
    public int pickIndex() {
        int lastSum = w[w.length - 1];
        int target = r.nextInt(lastSum) + 1;
        int p = Arrays.binarySearch(w, target);
        return p >= 0 ? p : -p - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
