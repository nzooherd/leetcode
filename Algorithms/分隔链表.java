/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode big = new ListNode(1);
		ListNode small = new ListNode(1);
		ListNode a = small;
		ListNode b = big;
		ListNode p = head;
		while(p != null) {
			if(p.val < x) {
				a.next = new ListNode(p.val);
				a = a.next;
			}
			else {
				b.next = new ListNode(p.val);
				b = b.next;
			}
			p = p.next;
		}
		a.next = big.next;
		return small.next;

	}
}