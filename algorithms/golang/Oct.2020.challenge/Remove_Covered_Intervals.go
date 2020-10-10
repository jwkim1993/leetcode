func removeCoveredIntervals(intervals [][]int) int {
    if len(intervals) < 2 {
        return len(intervals)
    }
    
    sort.Slice(intervals, func(i, j int) bool {
        if intervals[i][0] < intervals[j][0] {
            return true
        } else if intervals[i][0] > intervals[j][0] {
            return false
        }
        
        if intervals[i][1] < intervals[j][1] {
            return false
        } else {
            return true
        }
    })
    
    retCount := 0
    cmp := intervals[0]
    for idx := range intervals {
        if cmp[1] < intervals[idx][1] {
            retCount++
            cmp = intervals[idx]
        }
    }
    
    return retCount + 1
}
