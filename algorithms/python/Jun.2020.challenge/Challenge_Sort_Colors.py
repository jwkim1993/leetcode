class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        redIdx, blueIdx = 0, len(nums) - 1
        i = 0
        
        while i <= blueIdx:
                
            if nums[i] == 0:
                nums[redIdx], nums[i] = nums[i], nums[redIdx]
                i += 1
                redIdx += 1
                
            elif nums[i] == 2:
                nums[blueIdx], nums[i] = nums[i], nums[blueIdx]
                blueIdx -= 1
                
            else:
                i += 1
