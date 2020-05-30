class Solution:
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        
        @lru_cache(None)
        def totalSum(i:int, j:int) -> int:
            if i < 0 or j < 0: return 0
            if i >= len(mat): return totalSum(len(mat)-1, j)
            if j >= len(mat[0]): return totalSum(i, len(mat[0])-1)
            
            return totalSum(i, j-1) + totalSum(i-1, j) - totalSum(i-1, j-1) + mat[i][j]
    
        retList = []
        
        for ii in range(len(mat)):
            retList.append([]);
            for jj in range(len(mat[0])):
                retList[ii].append(totalSum(ii+K, jj+K)
                                  - totalSum(ii-K-1, jj+K)
                                  - totalSum(ii+K, jj-K-1)
                                  + totalSum(ii-K-1, jj-K-1))
        
        return retList
