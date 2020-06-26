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
    public int sumNumbers(TreeNode root) {
        
        return recSumNumbers(root, 0);
    }
    
    public int recSumNumbers(TreeNode root, int head) {
        if(root == null)
            return 0;
        
        int curVal = head*10 + root.val;
        if(root.left == null && root.right == null)
            return curVal;
        
        return recSumNumbers(root.left, curVal) + recSumNumbers(root.right, curVal);
    }
}
