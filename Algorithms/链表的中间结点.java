/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p = head;
        if(head == null || head.next == null) return head;
        ListNode q = head.next;
        if(q.next == null) {
            return q;
        }
        while(q.next != null){
            p = p.next;
            q = q.next;
            if(q.next == null) {
                return p;
            }else {
                q = q.next;
            }
        }
        return p.next;
        
    }
}