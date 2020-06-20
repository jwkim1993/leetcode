class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        retStr = ""
        perm = 1
        setList = [i for i in range(1, n+1)]
        
        for i in range(1, n):
            perm *= i
        
        for i in range(n-1, 0, -1):
            retStr += str(setList.pop((k-1)//perm))
            k = k - perm*((k-1)//perm)
            perm //= i
        
        retStr += str(setList.pop(0))
        
        return retStr
