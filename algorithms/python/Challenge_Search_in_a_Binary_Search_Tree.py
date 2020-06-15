# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        currRoot = root
        while currRoot:
            if val == currRoot.val:
                return currRoot
            elif val < currRoot.val:
                currRoot = currRoot.left
            elif val > currRoot.val:
                currRoot = currRoot.right
        
        return currRoot
