/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode currRoot = root;
        
        while(currRoot != null) {
            if(val == currRoot.val)
                return currRoot;
            else if(val < currRoot.val)
                currRoot = currRoot.left;
            else
                currRoot = currRoot.right;
        }
        
        return currRoot;
    }
}
