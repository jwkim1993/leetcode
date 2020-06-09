class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        
        sIdx = 0
        tIdx = 0
        while sIdx < len(s) and tIdx < len(t):
            if t[tIdx] == s[sIdx]:
                sIdx += 1
            tIdx += 1
            
        if sIdx == len(s):
            return True
        
        return False
