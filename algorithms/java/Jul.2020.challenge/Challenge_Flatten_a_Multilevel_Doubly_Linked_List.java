/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return head;
        
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = head;
        
        while(cur.child != null || cur.next != null || stack.size() != 0) {
            
            if(cur.child != null && cur.next != null)
                stack.push(cur.next);
            
            if(cur.child != null) {
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            
            if(cur.next == null && stack.size() != 0) {
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}
