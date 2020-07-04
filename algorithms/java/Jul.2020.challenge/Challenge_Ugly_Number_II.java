class Solution {
    private long[] multi = {2L, 3L, 5L};
    
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> s = new HashSet<>();
        pq.offer(1L); s.add(1L);
        
        for(int i = 1 ; i < n ; ++i) {
            long base = pq.poll();
            for(int j = 0 ; j < 3 ; ++j) {
                if(!s.contains(base*multi[j])) {
                    pq.offer(base*multi[j]);
                    s.add(base*multi[j]);
                }
            }
        }
        
        return pq.poll().intValue();
    }
}
