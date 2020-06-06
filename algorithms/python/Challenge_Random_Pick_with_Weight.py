from bisect import bisect_left

class Solution:

    def __init__(self, w: List[int]):
        self.w = w
        for i in range(1, len(w)):
            self.w[i] = self.w[i] + self.w[i-1] 

    def pickIndex(self) -> int:
        idx = random.randint(1, self.w[-1])
        return bisect_left(self.w, idx)

# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()
