/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode cur = head;
        
        while(cur != null) {
            dq.offer(cur);
            cur = cur.next;
        }
        
        cur = new ListNode();
        while(dq.size() > 1) {
            cur.next = dq.pollFirst();
            cur.next.next = dq.pollLast();
            // System.out.printf("cur.next.val: %d, cur.next.next.val: %d\n", cur.next.val, cur.next.next.val);
            cur = cur.next.next;
        }
        if(dq.size() == 1) {
            cur.next = dq.poll();
            cur = cur.next;
        }
        
        cur.next = null;
    }
}
