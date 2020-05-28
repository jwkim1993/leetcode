class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        perm = list(range(m,0,-1))
        retList = []
        
        for query in queries:
            retList.append(m-1 - perm.index(query))
            perm.pop(m-1 - retList[-1])
            perm.append(query)
            
        return retList
