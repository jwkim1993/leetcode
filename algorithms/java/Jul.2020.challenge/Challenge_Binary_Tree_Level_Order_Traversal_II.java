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
    private Map<Integer, List<Integer>> dict;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dict = new HashMap<>();
        List<List<Integer>> retList = new ArrayList<>();
        
        if(root != null)
            recurFunc(root, 0);
        
        int depN = dict.size();
        
        for(int i = depN - 1 ; i >= 0; --i)
            retList.add(dict.get(i));
        
        return retList;
    }
    
    private void recurFunc(TreeNode root, int dep) {
        // trust that root is not null
        
        if(!dict.containsKey(dep)) {
            dict.put(dep, new ArrayList<Integer>());
        }
        
        dict.get(dep).add(root.val);
        if(root.left != null)
            recurFunc(root.left, dep+1);
        if(root.right != null)
            recurFunc(root.right, dep+1);
    }
}
