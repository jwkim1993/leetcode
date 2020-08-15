class Solution {
    
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length < 2)
            return 0;
        
        int overlaps = 0;
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        
        int prevEnd = intervals[0][0];
        for(int[] tmp: intervals) {
            if(tmp[0] >= prevEnd) {
                prevEnd = tmp[1];
                continue;
            }
            
            ++overlaps;
            if(tmp[1] < prevEnd)
                prevEnd = tmp[1];
        }
        
        return overlaps;
    }
}
