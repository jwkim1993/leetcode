class Solution:

    def __init__(self, w: List[int]):
        self.w = w;
        for i in range(1, len(w)):
            self.w[i] = self.w[i] + self.w[i-1];            

    def pickIndex(self) -> int:
        idx = random.randint(1, self.w[-1])
        lastIdx = len(self.w) - 1
        firstIdx = 0
        while(True):
            mid = (lastIdx + firstIdx) // 2
            if idx > self.w[mid]:
                firstIdx = mid
            elif idx < self.w[mid]:
                lastIdx = mid
            else:
                return mid
            
            if mid == (lastIdx + firstIdx) // 2:
                return mid if idx < self.w[mid] else mid + 1
            
# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
