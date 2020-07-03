class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        if len(nums) < 2:
            return nums
        
        nums.sort()
        
        N = len(nums)
        c = [1 for _ in range(N)]
        dp = [0 for _ in range(N)]
        maxIdx = -1
        maxVal = -1
        for i in range(1, N):
            for j in range(0, i):
                if nums[i]%nums[j] == 0 and c[i] <= c[j] + 1:
                    c[i] = c[j] + 1
                    dp[i] = j
                    
            if c[i] > maxVal:
                maxIdx, maxVal = i, c[i]
                
        retList = []
        for _ in range(maxVal):
            retList.append(nums[maxIdx])
            maxIdx = dp[maxIdx]
        
        return retList
