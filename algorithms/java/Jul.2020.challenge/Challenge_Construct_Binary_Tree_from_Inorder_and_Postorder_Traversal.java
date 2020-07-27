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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int N = inorder.length;
        
        int ptr = 0;
        TreeNode parent = null;
        while(ptr < N) {
            parent = new TreeNode(inorder[ptr]);
            if(!stack.isEmpty())
                parent.left = stack.pop();
                
            if(inorder[ptr] != postorder[ptr]) {
                int endIdx = findIdx(postorder, ptr+1, inorder[ptr]);
                int[] sio = Arrays.copyOfRange(inorder, ptr+1, endIdx+1);
                int[] spo = Arrays.copyOfRange(postorder, ptr, endIdx);
                parent.right = buildTree(sio, spo);
                ptr = endIdx;
            }
            
            stack.push(parent);
            ++ptr;
        }
        
        return parent;
    }
    
    public int findIdx(int[] arr, int start, int target) {
        int i = start;
        while(i < arr.length && arr[i] != target)
            ++i;
        
        return i;
    }
}
