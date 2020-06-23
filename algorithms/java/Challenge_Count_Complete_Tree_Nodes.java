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
    public int countNodes(TreeNode root) {
        return recurNodes(root, 1);
    }
    
    public int recurNodes(TreeNode root, int num) {
        if(root == null)
            return 0;
        
        return Math.max(recurNodes(root.right, 2*num+1), Math.max(recurNodes(root.left, 2*num), num));
    }
}
