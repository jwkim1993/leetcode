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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> retList = new ArrayList<>();
        q.offer(root);
        
        int level = 0;
        int loopCount = 1;
        while(q.size() > 0) {
            int prevLevelNum = loopCount;
            loopCount = 0;
            retList.add(new ArrayList<>());
            
            for(int i = 0 ; i < prevLevelNum ; ++i) {
                TreeNode curNode = q.poll();
                retList.get(level).add(curNode.val);
                if(curNode.left != null) {
                    q.offer(curNode.left);
                    ++loopCount;
                }
                if(curNode.right != null) {
                    q.offer(curNode.right);
                    ++loopCount;
                }
            }
            
            if(level%2 == 1) // even
                Collections.reverse(retList.get(level));
            ++level;
        }
        
        return retList;
    }
}
