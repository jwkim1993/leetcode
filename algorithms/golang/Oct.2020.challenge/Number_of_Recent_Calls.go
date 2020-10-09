type RecentCounter struct {
    Times []int
    ValidIndex int
}


func Constructor() RecentCounter {
    rc := RecentCounter{}
    rc.Times = []int{}
    rc.ValidIndex = 0
    
    return rc
}


func (this *RecentCounter) Ping(t int) int {
    this.Times = append(this.Times, t)
    
    for t - this.Times[this.ValidIndex] > 3000 {
        this.ValidIndex++
    }
    
    return len(this.Times) - this.ValidIndex
}


/**
 * Your RecentCounter object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Ping(t);
 */
