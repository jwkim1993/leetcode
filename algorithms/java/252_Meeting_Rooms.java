class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length < 2)
            return true;
        
        int N = intervals.length;
        Arrays.sort(intervals, (x,y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        
        for(int i = 0 ; i < N-1; ++i) {
            if(intervals[i][1] > intervals[i+1][0])
                return false;
        }
        
        return true;
    }
}
