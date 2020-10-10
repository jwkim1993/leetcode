func findPairs(nums []int, k int) int {
    if nums == nil || len(nums) < 2 {
        return 0
    } 
    
    // sort the nums slice
    sort.Slice(nums, func(i, j int) bool {
        return nums[i] < nums[j]
    })
    
    // fmt.Printf("slice: %v\n", nums)
    
    sz := len(nums)
    retNum := 0
    fIdx := 0
    sIdx := 1
    
    for ;; {
        for sIdx < sz && (fIdx == sIdx || nums[sIdx] - nums[fIdx] < k) {
            sIdx++
        }
        // fmt.Println("sIdx: ", sIdx)
        
        if sIdx == sz {
            break
        }
        
        if nums[sIdx] - nums[fIdx] == k {
            retNum++
        }
        
        // avoid error on -1 idx
        tmp := nums[fIdx]
        for fIdx < sz && nums[fIdx] == tmp {
            fIdx++
        }
        // fmt.Println("fIdx: ", fIdx)
        
        if fIdx == sz {
            break
        }
    }
    
    return retNum
}
