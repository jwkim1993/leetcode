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
    public static class Coordi implements Comparable<Coordi> {
        int x;
        int y;
        int val;
        public Coordi(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Coordi other) {
            if(this.x != other.x)
                return this.x - other.x;
            if(this.y != other.y)
                return this.y - other.y;
            
            return this.val - other.val;
        }
    }
    
    List<Coordi> coordiList;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> retList = new ArrayList<>();
        coordiList = new ArrayList<>();
        
        dfs(root, 0, 0);
        Collections.sort(coordiList);
        
        int prev = coordiList.get(0).x;
        List<Integer> tmpList = new ArrayList<>();
        for(Coordi c : coordiList) {
            if(prev != c.x) {
                prev = c.x;
                retList.add(tmpList);
                tmpList = new ArrayList<>();
            }
            
            tmpList.add(c.val);
        }
        retList.add(tmpList);
        
        return retList;
    }
    
    public void dfs(TreeNode root, int x, int y) {
        if(root == null)
            return;
        
        coordiList.add(new Coordi(x, y, root.val));
        
        dfs(root.left, x-1, y+1);
        dfs(root.right, x+1, y+1);
    }
}
