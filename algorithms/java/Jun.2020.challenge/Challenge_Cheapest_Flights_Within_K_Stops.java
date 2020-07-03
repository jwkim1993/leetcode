class Solution {
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        for(int k = 0 ; k <= K ; k++) {
            int[] tmp = Arrays.copyOf(cost, n);
            for(int[] flight : flights) {
                int cur = flight[0], next = flight[1], price = flight[2];
                
                if(cost[cur] == Integer.MAX_VALUE)
                    continue;
                
                if(tmp[next] > cost[cur]+price) {
                    tmp[next] = cost[cur]+price;
                }
            }
            cost = tmp;
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
