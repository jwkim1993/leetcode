class Solution {    
    public int numSquares(int n) {
        if(n == 0)
            return 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1;
        
        for(int i = 2; i <= n; ++i) {
            for(int j = 1 ; j*j <= i; ++j) {
                dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
            }
        }
        
        // Arrays.stream(dp).forEach(x -> System.out.println(x));
        return dp[n];
    }
}
