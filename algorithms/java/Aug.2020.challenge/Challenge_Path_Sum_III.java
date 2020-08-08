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
    public int pathSum(TreeNode root, int sum) {
        int[] paramArr = new int[1001];
        paramArr[0] = sum;
        
        return pathSumRecur(root, paramArr, 1);
    }
    
    public int pathSumRecur(TreeNode root, int[] sum, int len) {
        if(root == null)
            return 0;
        
        // System.out.printf("[");
        // Arrays.stream(sum).forEach(x-> System.out.printf("%s ", x));
        // System.out.println("]");
        
        int retVal = 0;
        for(int i = 0 ; i < len; ++i) {
            if(sum[i] == root.val)
                ++retVal;
        }
        
        for(int i = 1 ; i < len; ++i) {
            sum[i] -= root.val;
        }
        sum[len] = sum[0] - root.val;
        
        retVal += pathSumRecur(root.left, sum, len+1) + pathSumRecur(root.right, sum, len+1);
        
        for(int i = 1 ; i < len; ++i) {
            sum[i] += root.val;
        }
        
        return retVal;
    }
}
