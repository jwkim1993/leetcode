class Solution {
    public int numTrees(int n) {
        if(n < 3)
            return n;
        
        int[] c = new int[n+1];
        c[0] = 1; c[1] = 1; c[2] = 2;
        
        for(int i = 3 ; i <= n ; ++i) {
            for(int j = 0 ; j < i ; ++j) {
                c[i] += c[j] * c[i-j-1];
            }
        }
        // Arrays.stream(c).forEach(x -> System.out.println(String.format("%d",x)));
        return c[n];
    }
}
