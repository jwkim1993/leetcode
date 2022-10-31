package neetcode

func containsDuplicate(nums []int) bool {
	// return solution1(nums)
	return solution2(nums)
}

// time complexity: O(n)
// space complexity: O(n)
func solution1(nums []int) bool {
	numMap := make(map[int]bool)

	for _, num := range nums {
		if _, ok := numMap[num]; ok {
			return true
		}

		numMap[num] = true
	}

	return false
}

// time complexity: O(n logn)
// space complexity: O(1)
func solution2(nums []int) bool {
	if len(nums) == 1 {
		return false
	}

	sort.Ints(nums)

	for i := 1; i < len(nums); i++ {
		if nums[i-1] == nums[i] {
			return true
		}
	}

	return false
}
