/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode ans = new ListNode(1);
		ListNode p = head;
		ListNode q = ans;
		while(p != null) {
			if(p.val != val) {
				q.next = new ListNode(p.val);
				q = q.next;
			}
			p = p.next;
		}
		return ans.next;
    }
}