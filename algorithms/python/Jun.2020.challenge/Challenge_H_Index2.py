class Solution:
    def hIndex(self, citations: List[int]) -> int:
        N = len(citations)
        
        if N == 0 or citations[-1] == 0:
            return 0
        if citations[0] >= N:
            return N
        
        for i in range(N-1, 0, -1):
            if citations[N-i] >= i:
                return i
        
        return 0
