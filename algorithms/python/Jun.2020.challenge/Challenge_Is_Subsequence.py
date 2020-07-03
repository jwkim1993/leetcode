class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        iter_target = iter(target)
        return all(char in iter_target for char in s)
