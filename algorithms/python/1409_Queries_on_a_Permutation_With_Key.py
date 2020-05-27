class Solution:
    def processQueries(self, queries: List[int], m: int) -> List[int]:
        perm = list(range(1,m+1))
        retList = []
        
        for query in queries:
            retList.append(perm.index(query))
            perm.remove(query)
            perm = [query] + perm
        
        return retList
