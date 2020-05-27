class NumArray:

    def __init__(self, nums: List[int]):
        self.dynmNums = [0];
        for num in nums:
            self.dynmNums.append(self.dynmNums[-1] + num);
        self.dynmNums = self.dynmNums[1:] + [0];
        
    def sumRange(self, i: int, j: int) -> int:
        return self.dynmNums[j] - self.dynmNums[i-1]
        


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
