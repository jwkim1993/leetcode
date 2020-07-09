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
    List<int[]> levelWidth;
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        levelWidth = new ArrayList<>();
        settingList(root, 0);
        
        int retVal = 0;
        for(int[] lenArr : levelWidth) {
            if(lenArr[0] > retVal)
                retVal = lenArr[0];
        }
        
        return retVal;
    }
    
    public void settingList(TreeNode cur, int depth) {
        if(levelWidth.size() < depth + 1) {
            levelWidth.add(new int[]{0,0});
        }
        
        levelWidth.get(depth)[0] += levelWidth.get(depth)[1] + 1;
        levelWidth.get(depth)[1] = 0;
        
        int count = 2;
        if(cur.left != null) {
            settingList(cur.left, depth+1);
        } else {
            for(int i = depth+1 ; i < levelWidth.size(); ++i) {
                levelWidth.get(i)[1] += Math.pow(2, i-(depth+1));
            }
        }
        
        if(cur.right != null) {
            settingList(cur.right, depth+1);
        } else {
            for(int i = depth+1 ; i < levelWidth.size(); ++i) {
                levelWidth.get(i)[1] += Math.pow(2, i-(depth+1));
            }
        }
    }
}
